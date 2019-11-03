package controllers

import form.{ AddMovieForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.Movie
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.MovieRepository

import scala.util.Try

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

  def edit() = Action { implicit request =>
    val error = {
      _: Form[EditMovieForm] =>
        println("ERROR MESSAGE: NOT MAPPING EDIT MOVIE FORM AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: EditMovieForm =>
        println(data)
        movieRepository.editMovie(data) match {
          case 0 => {
            BadRequest(Json.obj("message" -> s"Movie with id ${data.id} is not update!"))
          }
          case _ =>
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
        }
    }
    EditMovieForm.editMovieForm.bindFromRequest().fold(error, success)
  }

  def getMovie(id: Int) = Action { implicit request =>
    Ok(Json.toJson(movieRepository.getMovie(id)))
  }

  def getAll() = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        request.rawQueryString.contains("name") match {
          case true => {
            val arrayParams = request.rawQueryString.split("&")
            val current_page = arrayParams(0).substring(5).toInt
            val searchName = arrayParams(1).substring(5).replace("%20", " ")
            val per_page = 10
            movieRepository.getAllMovie().map((listMovies: List[Movie]) => {
              val listSearchedMovies = listMovies.filter(movie => movie.name.toLowerCase().contains(searchName.toLowerCase()))
              val total = listSearchedMovies.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListMovie = listSearchedMovies.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "movies" -> responseListMovie,
                "searchingName" -> searchName)
              Ok(obj)
            }).get
          }
          case _ => {
            val current_page = request.rawQueryString.substring(5).toInt
            val per_page = 10
            movieRepository.getAllMovie.map((listMovies: List[Movie]) => {
              val total = listMovies.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListMovie = listMovies.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "movies" -> responseListMovie)
              Ok(obj)
            }).get
          }
        }
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }

  def delete(id: Int) = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        movieRepository.deleteMovie(id).map((result: Int) => {
          println(result)
          val obj = Json.obj(
            "ok" -> true,
            "text" -> Json.obj())
          Ok(obj)
        }).get
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }
}