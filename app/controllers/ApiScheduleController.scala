package controllers

import form.{ AddMovieForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.Schedule
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.ScheduleRepository

import scala.util.Try

@Singleton
class ApiScheduleController @Inject() (cc: ControllerComponents, scheduleRepository: ScheduleRepository)
  extends AbstractController(cc) {

  def getAll() = Action { implicit request =>
    {
      if (request.headers.apply("Authorization") == "Bearer fake-jwt-token") {
        request.rawQueryString.contains("name") match {
          case true => {
            BadRequest(Json.obj("message" -> "abcdefghiklm"))
          }
          case _ => {
            val current_page = request.rawQueryString.substring(5).toInt
            val per_page = 10
            scheduleRepository.getAllSchedule.map((listSchedules: List[Schedule]) => {
              val total = listSchedules.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListSchedule = listSchedules.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "schedules" -> responseListSchedule)
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
        scheduleRepository.deleteSchedule(id).map((result: Int) => {
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