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

  def getScheduleByName(name: String): Try[Schedule] = {
    Try {
      Schedule.findBy(sqls.eq(Schedule.defaultAlias.name, name)).get
    }
  }

  def addSchedule(data: AddScheduleForm): Boolean = {
    this.getScheduleByName(data.name).map(_ => true)
      .recover {
        case _ =>
          {
            Schedule.createWithAttributes(
              Symbol("name") -> data.name,
              Symbol("idMovie") -> data.idMovie,
              Symbol("room") -> data.room,
              Symbol("startAt") -> data.startAt,
              Symbol("endAt") -> data.endAt,
              Symbol("date") -> data.date,
              Symbol("ticketPrice") -> data.ticketPrice)
          }
          false
      }.get
  }

  def deleteSchedule(id: Int): Try[Int] = {
    Try {
      Schedule.deleteById(id)
    }
  }
}
