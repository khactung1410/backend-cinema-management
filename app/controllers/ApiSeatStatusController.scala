package controllers

import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.{ Schedule, SeatStatus }
import play.api.data.Form
import play.api.http.Status.CONFLICT
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.ScheduleRepository
import services.SeatStatusService

import scala.util.Try

@Singleton
class ApiSeatStatusController @Inject() (cc: ControllerComponents, scheduleRepository: ScheduleRepository, seatStatusService: SeatStatusService)
  extends AbstractController(cc) {

  def getBySchedule() = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        val idSchedule = request.rawQueryString.substring(11).toInt
        seatStatusService.getBySchedule(idSchedule) match {
          case listSeatStatus: List[SeatStatus] => {
            println("listStatus: " + listSeatStatus)
            val obj = Json.obj("listSeatStatus" -> listSeatStatus)
            Ok(obj)
          }
          case _ => {
            Conflict(Json.obj("message" -> s"No seatStatus found with this schedule!"))
          }
        }
        BadRequest(Json.obj("message" -> "You're not login!"))
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }
}