package form

import play.api.data.Form
import play.api.data.Forms._

case class EditScheduleForm(id: String, name: String, idMovie: String, room: String, idRoom: String, startAt: String, endAt: String, date: String, ticketPrice: String, quantityTicket: String, remainingTicket: String)
object EditScheduleForm {
  val editScheduleForm: Form[EditScheduleForm] = Form(
    mapping(
      "id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "idMovie" -> nonEmptyText,
      "room" -> nonEmptyText,
      "idRoom" -> nonEmptyText,
      "startAt" -> nonEmptyText,
      "endAt" -> nonEmptyText,
      "date" -> nonEmptyText,
      "ticketPrice" -> nonEmptyText,
      "quantityTicket" -> nonEmptyText,
      "remainingTicket" -> nonEmptyText)(EditScheduleForm.apply)(EditScheduleForm.unapply))
}