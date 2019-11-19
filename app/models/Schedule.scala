package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class Schedule(id: Int, idMovie: Int, name: String, idRoom: Int, room: String, startAt: String, endAt: String, date: String, ticketPrice: String, quantityTicket: Int, remainingTicket: Int)

object Schedule extends SkinnyCRUDMapper[Schedule] {
  implicit val format = Json.format[Schedule]
  override lazy val defaultAlias = createAlias("s")
  override lazy val tableName = "schedule"

  override def extract(rs: WrappedResultSet, s: ResultName[Schedule]): Schedule = new Schedule(
    id = rs.get(s.id),
    idMovie = rs.get(s.idMovie),
    name = rs.get(s.name),
    idRoom = rs.get(s.idRoom),
    room = rs.get(s.room),
    startAt = rs.get(s.startAt),
    endAt = rs.get(s.endAt),
    date = rs.get(s.date),
    ticketPrice = rs.get(s.ticketPrice),
    quantityTicket = rs.get(s.quantityTicket),
    remainingTicket = rs.get(s.remainingTicket))
}

