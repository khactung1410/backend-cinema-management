package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class SeatStatus(id: Int, idSeat: Int, idRoom: Int, startAt: String, endAt: String, date: String, status: String)

object SeatStatus extends SkinnyCRUDMapper[SeatStatus] {
  implicit val format = Json.format[SeatStatus]
  override lazy val defaultAlias = createAlias("s")
  override lazy val tableName = "seatstatus"

  override def extract(rs: WrappedResultSet, s: ResultName[SeatStatus]): SeatStatus = new SeatStatus(
    id = rs.get(s.id),
    idSeat = rs.get(s.idSeat),
    idRoom = rs.get(s.idRoom),
    startAt = rs.get(s.startAt),
    endAt = rs.get(s.endAt),
    date = rs.get(s.date),
    status = rs.get(s.status))
}

