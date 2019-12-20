package repositories
import form.{ AddMovieForm, AddScheduleForm, AddSeatForm, EditMovieForm }
import javax.inject.Singleton
import models.{ Schedule, Seat }
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class SeatRepository {

  def getAllSeatByRoom(idRoom: Int): Try[List[Seat]] =
    Try {
      Seat.findAllBy(sqls.eq(Seat.defaultAlias.idRoom, idRoom))
    }

  def addSeat(idRoom: Int, name: String): Boolean = {
    Seat.createWithAttributes(
      Symbol("idRoom") -> idRoom,
      Symbol("name") -> name)
    true
  }
}
