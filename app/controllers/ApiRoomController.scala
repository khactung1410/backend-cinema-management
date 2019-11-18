package controllers

import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.Room
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.RoomRepository

import scala.util.Try

@Singleton
class ApiRoomController @Inject() (cc: ControllerComponents, roomRepository: RoomRepository)
  extends AbstractController(cc) {

  def getAll() = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        roomRepository.getAllRoom().map((listRoom: List[Room]) => {
          val obj = Json.obj("allRoom" -> listRoom)
          Ok(obj)
        }).get
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }

}