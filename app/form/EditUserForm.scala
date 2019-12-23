package form

import play.api.data.Form
import play.api.data.Forms._

case class EditUserForm(id: String, fullname: String, address: String, phone: String, username: String, role: String)
object EditUserForm {
  val editUserForm: Form[EditUserForm] = Form(
    mapping(
      "id" -> nonEmptyText,
      "fullname" -> nonEmptyText,
      "address" -> nonEmptyText,
      "phone" -> nonEmptyText,
      "username" -> nonEmptyText,
      "role" -> nonEmptyText)(EditUserForm.apply)(EditUserForm.unapply))
}