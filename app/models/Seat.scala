package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class Seat(id: Int, idRoom: Int, name: String)

object Seat extends SkinnyCRUDMapper[Seat] {
  implicit val format = Json.format[Seat]
  override lazy val defaultAlias = createAlias("s")
  override lazy val tableName = "seat"

  override def extract(rs: WrappedResultSet, s: ResultName[Seat]): Seat = new Seat(
    id = rs.get(s.id),
    idRoom = rs.get(s.idRoom),
    name = rs.get(s.name))
}
