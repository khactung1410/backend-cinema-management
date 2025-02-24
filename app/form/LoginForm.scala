package form

import play.api.data.Form
import play.api.data.Forms._

case class LoginForm(username: String, password: String)

object LoginForm {
  val loginForm: Form[LoginForm] = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText)(LoginForm.apply)(LoginForm.unapply))
}