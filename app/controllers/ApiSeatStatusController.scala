package controllers

import form.{ AddMovieForm, AddScheduleForm, ChangeSeatStatusForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.{ Schedule, SeatStatus }
import play.api.data.Form
import play.api.http.Status.CONFLICT
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.{ ScheduleRepository, SeatStatusRepository }
import services.SeatStatusService

import scala.util.Try

@Singleton
class ApiSeatStatusController @Inject() (cc: ControllerComponents, scheduleRepository: ScheduleRepository, seatStatusRepository: SeatStatusRepository, seatStatusService: SeatStatusService)
  extends AbstractController(cc) {

  def getBySchedule() = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        val idSchedule = request.rawQueryString.substring(11).toInt
        seatStatusService.getBySchedule(idSchedule) match {
          case listSeatStatus: List[SeatStatus] => {
            val obj = Json.obj("listSeatStatus" -> listSeatStatus)
            Ok(obj)
          }
          case _ => {
            Conflict(Json.obj("message" -> s"No seatStatus found with this schedule!"))
          }
        }
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }

  def changeStatus() = Action { implicit request =>
    val error = {
      _: Form[ChangeSeatStatusForm] =>
        println("ERROR MESSAGE: NOT MAPPING CHANGE STATUS FORM AND DATA FROM CLIENT")
        BadRequest(Json.obj("message" -> "not map"))
    }
    val success = {
      data: ChangeSeatStatusForm =>
        val ids = data.ids.split(",")
        ids.map(id => {
          seatStatusRepository.changeStatus(id.toInt) match {
            case 0 => {
              BadRequest(Json.obj("message" -> s"seatStatuses are not update!"))
            }
            case _ =>
              val obj = Json.obj(
                "ok" -> true,
                "text" -> Json.obj())
              Ok(obj)
          }
        })
        Ok
    }
    ChangeSeatStatusForm.changeSeatStatusForm.bindFromRequest().fold(error, success)
  }
}