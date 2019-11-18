package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class Room(id: Int, name: String, totalSeat: String)

object Room extends SkinnyCRUDMapper[Room] {
  implicit val format = Json.format[Room]
  override lazy val defaultAlias = createAlias("r")
  override lazy val tableName = "room"

  override def extract(rs: WrappedResultSet, r: ResultName[Room]): Room = new Room(
    id = rs.get(r.id),
    name = rs.get(r.name),
    totalSeat = rs.get(r.totalSeat))
}

