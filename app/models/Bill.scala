package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class Bill(id: Int, name: String, room: String, seats: String, employee: String, startAt: String, endAt: String, date: String, price: Int, totalSeat: Int, buyAt: String)

object Bill extends SkinnyCRUDMapper[Bill] {
  implicit val format = Json.format[Bill]
  override lazy val defaultAlias = createAlias("b")
  override lazy val tableName = "bill"

  override def extract(rs: WrappedResultSet, b: ResultName[Bill]): Bill = new Bill(
    id = rs.get(b.id),
    name = rs.get(b.name),
    room = rs.get(b.room),
    seats = rs.get(b.seats),
    employee = rs.get(b.employee),
    startAt = rs.get(b.startAt),
    endAt = rs.get(b.endAt),
    date = rs.get(b.date),
    price = rs.get(b.price),
    totalSeat = rs.get(b.totalSeat),
    buyAt = rs.get(b.buyAt))
}

