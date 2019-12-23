package form

import play.api.data.Form
import play.api.data.Forms._

case class AddBillForm(name: String, room: String, seats: String, employee: String, startAt: String, endAt: String, date: String, price: String, totalSeat: String, buyAt: String)
object AddBillForm {
  val addBillForm: Form[AddBillForm] = Form(
    mapping(
      "name" -> nonEmptyText,
      "room" -> nonEmptyText,
      "seats" -> nonEmptyText,
      "employee" -> nonEmptyText,
      "startAt" -> nonEmptyText,
      "endAt" -> nonEmptyText,
      "date" -> nonEmptyText,
      "price" -> nonEmptyText,
      "totalSeat" -> nonEmptyText,
      "buyAt" -> nonEmptyText)(AddBillForm.apply)(AddBillForm.unapply))
}