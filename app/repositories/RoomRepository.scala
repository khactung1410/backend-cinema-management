package repositories
import form.AddRoomForm
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

  def deleteRoom(id: Int): Try[Int] = {
    Try {
      Room.deleteById(id)
    }
  }

  def getRoomByName(name: String): Try[Room] = {
    Try {
      Room.findBy(sqls.eq(Room.defaultAlias.name, name)).get
    }
  }

  def addRoom(data: AddRoomForm): Boolean = {
    this.getRoomByName(data.name).map(_ => true)
      .recover {
        case _ =>
          {
            Room.createWithAttributes(
              Symbol("name") -> data.name,
              Symbol("totalSeat") -> data.totalSeat,
              Symbol("square") -> data.square,
              Symbol("location") -> data.location,
              Symbol("typeRoom") -> data.typeRoom,
              Symbol("createAt") -> data.createAt,
              Symbol("updateAt") -> data.updateAt)
          }
          false
      }.get
  }
}
