package repositories
import javax.inject.Singleton
import models.Room
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class RoomRepository {

  def getAllRoom(): Try[List[Room]] =
    Try {
      Room.findAll()
    }

  def getRoom(id: Int): Option[Room] = {
    Room.findById(id)
  }
}
