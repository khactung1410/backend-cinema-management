package form

import play.api.data.Form
import play.api.data.Forms._

case class AddMovieForm(name: String, genre: String, director: String, publicYear: String, description: String)
object AddMovieForm {
  val addMovieForm: Form[AddMovieForm] = Form(
    mapping(
      "name" -> nonEmptyText,
      "genre" -> nonEmptyText,
      "director" -> nonEmptyText,
      "publicYear" -> nonEmptyText,
      "description" -> nonEmptyText)(AddMovieForm.apply)(AddMovieForm.unapply))
}