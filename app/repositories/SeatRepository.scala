package repositories
import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
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
}
