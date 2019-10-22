package controllers

import form.AddMovieForm
import javax.inject.{ Inject, Singleton }
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.MovieRepository

@Singleton
class ApiMovieController @Inject() (cc: ControllerComponents, movieRepository: MovieRepository)
  extends AbstractController(cc) {

  def add() = Action { implicit request =>
    val error = {
      _: Form[AddMovieForm] =>
        println("ERROR MESSAGE: NOT MAPPING ADD MOVIE FORM AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: AddMovieForm =>
        movieRepository.addMovie(data) match {
          case true => {
            print(data)
            BadRequest(Json.obj("message" -> s"Movie with name ${data.name} is already taken!"))
          }
          case _ =>
            print(data)
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
        }
    }
    AddMovieForm.addMovieForm.bindFromRequest().fold(error, success)
  }
}