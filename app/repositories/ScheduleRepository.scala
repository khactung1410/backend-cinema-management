package repositories
import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
import javax.inject.Singleton
import models.Schedule
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class ScheduleRepository {

  def getAllSchedule(): Try[List[Schedule]] =
    Try {
      Schedule.findAll().reverse
    }

  def getSchedule(id: Int): Seq[Schedule] = {
    Schedule.findAllByIds(id)
  }

  //  def getScheduleByName(name: String): Try[Schedule] = {
  //    Try {
  //      Schedule.findBy(sqls.eq(Schedule.defaultAlias.name, name)).get
  //    }
  //  }

  def getScheduleByRoom(nameRoom: String): Try[List[Schedule]] = {
    Try {
      Schedule.findAllBy(sqls.eq(Schedule.defaultAlias.room, nameRoom))
      //      Schedule.findBy(sqls.eq(Schedule.defaultAlias.idRoom, idRoom)).get
    }
  }

  def addSchedule(data: AddScheduleForm): Boolean = {
    this.getScheduleByRoom(data.room).map(listSchedule => {
      listSchedule.map(schedule => {
        println(schedule.startAt < data.endAt)
        println(data.endAt <= schedule.endAt)
        println(schedule.startAt < data.startAt)
        println(data.startAt <= schedule.endAt)
        if ((schedule.startAt < data.endAt && data.endAt <= schedule.endAt) || (schedule.startAt < data.startAt && data.startAt <= schedule.endAt)) return false
      })
      Schedule.createWithAttributes(
        Symbol("name") -> data.name,
        Symbol("idMovie") -> data.idMovie,
        Symbol("idRoom") -> data.idRoom,
        Symbol("room") -> data.room,
        Symbol("startAt") -> data.startAt,
        Symbol("endAt") -> data.endAt,
        Symbol("date") -> data.date,
        Symbol("ticketPrice") -> data.ticketPrice)
      true
    })
      .recover {
        case _ =>
          {
            Schedule.createWithAttributes(
              Symbol("name") -> data.name,
              Symbol("idMovie") -> data.idMovie,
              Symbol("idRoom") -> data.idRoom,
              Symbol("room") -> data.room,
              Symbol("startAt") -> data.startAt,
              Symbol("endAt") -> data.endAt,
              Symbol("date") -> data.date,
              Symbol("ticketPrice") -> data.ticketPrice)
          }
          true
      }.get
  }

  def deleteSchedule(id: Int): Try[Int] = {
    Try {
      Schedule.deleteById(id)
    }
  }
}
