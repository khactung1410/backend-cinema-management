package form

import play.api.data.Form
import play.api.data.Forms._

case class RegisterForm(fullName: String, address: String, phone: String, userName: String, password: String)
object RegisterForm {
  val registerForm: Form[RegisterForm] = Form(
    mapping(
      "fullname" -> nonEmptyText,
      "address" -> nonEmptyText,
      "phone" -> nonEmptyText,
      "username" -> nonEmptyText,
      "password" -> nonEmptyText)(RegisterForm.apply)(RegisterForm.unapply))
}