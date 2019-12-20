package form

import play.api.data.Form
import play.api.data.Forms._

case class AddSeatForm(idRoom: Int, name: String)
object AddSeatForm {
  val addSeatForm: Form[AddSeatForm] = Form(
    mapping(
      "idRoom" -> number,
      "name" -> nonEmptyText)(AddSeatForm.apply)(AddSeatForm.unapply))
}