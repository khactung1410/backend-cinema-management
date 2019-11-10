package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class Schedule(id: Int, name: String, room: String, startAt: String, endAt: String, date: String, ticketPrice: String)

object Schedule extends SkinnyCRUDMapper[Schedule] {
  implicit val format = Json.format[Schedule]
  override lazy val defaultAlias = createAlias("s")
  override lazy val tableName = "schedule"

  override def extract(rs: WrappedResultSet, s: ResultName[Schedule]): Schedule = new Schedule(
    id = rs.get(s.id),
    name = rs.get(s.name),
    room = rs.get(s.room),
    startAt = rs.get(s.startAt),
    endAt = rs.get(s.endAt),
    date = rs.get(s.date),
    ticketPrice = rs.get(s.ticketPrice))
}

