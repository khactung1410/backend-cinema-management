package repositories
import form.{ AddMovieForm, AddScheduleForm, EditMovieForm, EditScheduleForm }
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

  def getScheduleByRoom(idRoom: Int): Try[List[Schedule]] = {
    Try {
      Schedule.findAllBy(sqls.eq(Schedule.defaultAlias.idRoom, idRoom))
    }
  }

  def editSchedule(data: EditScheduleForm): Int = {
    Schedule.updateById(data.id.toInt).withAttributes(
      Symbol("name") -> data.name,
      Symbol("idMovie") -> data.idMovie,
      Symbol("idRoom") -> data.idRoom,
      Symbol("room") -> data.room,
      Symbol("startAt") -> data.startAt,
      Symbol("endAt") -> data.endAt,
      Symbol("date") -> data.date,
      Symbol("ticketPrice") -> data.ticketPrice,
      Symbol("quantityTicket") -> data.quantityTicket,
      Symbol("remainingTicket") -> data.remainingTicket)
  }

  def addSchedule(data: AddScheduleForm, totalSeat: Int): Option[AddScheduleForm] = {
    this.getScheduleByRoom(data.idRoom.toInt).map(listSchedule => {
      val listScheduleinTime: List[Schedule] = listSchedule.filter(schedule => {
        ((schedule.date == data.date) && (schedule.startAt < data.endAt && data.endAt <= schedule.endAt)) || ((schedule.date == data.date) && (schedule.startAt < data.startAt && data.startAt <= schedule.endAt))
      })
      if (listScheduleinTime.length == 0) {
        Schedule.createWithAttributes(
          Symbol("name") -> data.name,
          Symbol("idMovie") -> data.idMovie,
          Symbol("idRoom") -> data.idRoom,
          Symbol("room") -> data.room,
          Symbol("startAt") -> data.startAt,
          Symbol("endAt") -> data.endAt,
          Symbol("date") -> data.date,
          Symbol("ticketPrice") -> data.ticketPrice,
          Symbol("quantityTicket") -> totalSeat,
          Symbol("remainingTicket") -> totalSeat)
        Some(data)
      } else None
    }).get
  }

  def deleteSchedule(id: Int): Try[Int] = {
    Try {
      Schedule.deleteById(id)
    }
  }
}
