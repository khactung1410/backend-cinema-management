package controllers

import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.{ Room, Seat }
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.{ RoomRepository, SeatRepository }

import scala.util.Try

@Singleton
class ApiSeatController @Inject() (cc: ControllerComponents, seatRepository: SeatRepository)
  extends AbstractController(cc) {

  def getSeatByRoom() = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        val idRoom = request.rawQueryString.substring(7).toInt
        seatRepository.getAllSeatByRoom(idRoom).map((listSeat: List[Seat]) => {
          val obj = Json.obj("listSeatByRoom" -> listSeat)
          Ok(obj)
        }).get
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }

}