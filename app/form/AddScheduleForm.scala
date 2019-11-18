package form

import play.api.data.Form
import play.api.data.Forms._

case class AddScheduleForm(name: String, idMovie: String, room: String, idRoom: String, startAt: String, endAt: String, date: String, ticketPrice: String)
object AddScheduleForm {
  val addScheduleForm: Form[AddScheduleForm] = Form(
    mapping(
      "name" -> nonEmptyText,
      "idMovie" -> nonEmptyText,
      "room" -> nonEmptyText,
      "idRoom" -> nonEmptyText,
      "startAt" -> nonEmptyText,
      "endAt" -> nonEmptyText,
      "date" -> nonEmptyText,
      "ticketPrice" -> nonEmptyText)(AddScheduleForm.apply)(AddScheduleForm.unapply))
}