package form

import play.api.data.Form
import play.api.data.Forms._

case class AddGenreForm(name: String, country: String, totalMovieHas: String, language: String)
object AddGenreForm {
  val addGenreForm: Form[AddGenreForm] = Form(
    mapping(
      "name" -> nonEmptyText,
      "country" -> nonEmptyText,
      "totalMovieHas" -> nonEmptyText,
      "language" -> nonEmptyText)(AddGenreForm.apply)(AddGenreForm.unapply))
}