package form

import play.api.data.Form
import play.api.data.Forms._

case class ChangeSeatStatusForm(ids: String)
object ChangeSeatStatusForm {
  val changeSeatStatusForm: Form[ChangeSeatStatusForm] = Form(
    mapping(
      "ids" -> nonEmptyText)(ChangeSeatStatusForm.apply)(ChangeSeatStatusForm.unapply))
}