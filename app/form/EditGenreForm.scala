package form

import play.api.data.Form
import play.api.data.Forms._

case class EditGenreForm(id: String, name: String, country: String, language: String)
object EditGenreForm {
  val editGenreForm: Form[EditGenreForm] = Form(
    mapping(
      "id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "country" -> nonEmptyText,
      "language" -> nonEmptyText)(EditGenreForm.apply)(EditGenreForm.unapply))
}