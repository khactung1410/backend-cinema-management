package controllers

import form.{ AddGenreForm, AddScheduleForm, EditMovieForm, EditGenreForm }
import javax.inject.{ Inject, Singleton }
import models.Genre
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.GenreRepository

import scala.util.Try

@Singleton
class ApiGenreController @Inject() (cc: ControllerComponents, genreRepository: GenreRepository)
  extends AbstractController(cc) {

  def add() = Action { implicit request =>
    val error = {
      _: Form[AddGenreForm] =>
        println("ERROR MESSAGE: NOT MAPPING ADD GENRE FORM AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: AddGenreForm =>
        genreRepository.addGenre(data) match {
          case true => {
            print(data)
            BadRequest(Json.obj("message" -> s"Genre with name ${data.name} is already taken!"))
          }
          case _ =>
            print(data)
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
        }
    }
    AddGenreForm.addGenreForm.bindFromRequest().fold(error, success)
  }

  def getGenre(id: Int) = Action { implicit request =>
    Ok(Json.toJson(genreRepository.getGenre(id)))
  }

  def getAll() = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        request.rawQueryString.contains("name") match {
          case true => {
            var current_page = 1
            var searchName = ""
            request.queryString.map {
              case (k, v) => {
                if (k == "page") current_page = v(0).toInt
                if (k == "name") searchName = v(0)
              }
            }
            val per_page = 10
            genreRepository.getAllGenre().map((listGenres: List[Genre]) => {
              val listSearchedGenres = listGenres.filter(genre => genre.name.toLowerCase().contains(searchName.toLowerCase()))
              val total = listSearchedGenres.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListGenre = listSearchedGenres.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "genres" -> responseListGenre,
                "allGenre" -> listGenres,
                "searchingName" -> searchName)
              Ok(obj)
            }).get
          }
          case _ => {
            val current_page = request.rawQueryString.substring(5).toInt
            val per_page = 10
            genreRepository.getAllGenre.map((listGenres: List[Genre]) => {
              val total = listGenres.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListGenre = listGenres.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "genres" -> responseListGenre,
                "allGenre" -> listGenres)
              Ok(obj)
            }).getOrElse(BadRequest)
          }
        }
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }

  def edit() = Action { implicit request =>
    val error = {
      _: Form[EditGenreForm] =>
        println("ERROR MESSAGE: NOT MAPPING EDIT GENRE FORM AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: EditGenreForm =>
        println(data)
        genreRepository.editGenre(data) match {
          case 0 => {
            BadRequest(Json.obj("message" -> s"Genre with id ${data.id} is not update!"))
          }
          case _ =>
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
        }
    }
    EditGenreForm.editGenreForm.bindFromRequest().fold(error, success)
  }

  def delete(id: Int) = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        genreRepository.deleteGenre(id).map((result: Int) => {
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