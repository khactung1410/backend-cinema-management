package repositories
import form.{ AddScheduleForm }
import javax.inject.Singleton
import models.{ Seat, SeatStatus }
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class SeatStatusRepository {

  def addSeatStatus(data: AddScheduleForm, seat: Seat): Boolean = {
    SeatStatus.createWithAttributes(
      Symbol("idSeat") -> seat.id,
      Symbol("idRoom") -> data.idRoom,
      Symbol("startAt") -> data.startAt,
      Symbol("endAt") -> data.endAt,
      Symbol("date") -> data.date,
      Symbol("status") -> "EMPTY")
    true
  }

}
