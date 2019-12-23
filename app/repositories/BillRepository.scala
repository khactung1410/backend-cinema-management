package repositories
import form.{ AddBillForm }
import javax.inject.Singleton
import models.{ Bill }
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class BillRepository {

  def getAllBill(): Try[List[Bill]] =
    Try {
      Bill.findAll().reverse
    }

  def getBill(id: Int): Seq[Bill] = {
    Bill.findAllByIds(id)
  }

  def addBill(data: AddBillForm): Boolean = {
    Bill.createWithAttributes(
      Symbol("name") -> data.name,
      Symbol("room") -> data.room,
      Symbol("seats") -> data.seats,
      Symbol("employee") -> data.employee,
      Symbol("startAt") -> data.startAt,
      Symbol("endAt") -> data.endAt,
      Symbol("date") -> data.date,
      Symbol("price") -> data.price.toInt,
      Symbol("totalSeat") -> data.totalSeat.toInt,
      Symbol("buyAt") -> data.buyAt)
    true
  }

  def deleteBill(id: Int): Try[Int] = {
    Try {
      Bill.deleteById(id)
    }
  }
}
