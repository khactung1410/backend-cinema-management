package form

import play.api.data.Form
import play.api.data.Forms._

case class EditMovieForm(id: String, name: String, genre: String, director: String, publicYear: String, description: String, trailer: String)
object EditMovieForm {
  val editMovieForm: Form[EditMovieForm] = Form(
    mapping(
      "id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "genre" -> nonEmptyText,
      "director" -> nonEmptyText,
      "publicYear" -> nonEmptyText,
      "description" -> nonEmptyText,
      "trailer" -> nonEmptyText)(EditMovieForm.apply)(EditMovieForm.unapply))
}