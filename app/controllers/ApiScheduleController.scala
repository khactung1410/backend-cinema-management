package controllers

import form.{ AddMovieForm, AddScheduleForm, EditMovieForm, EditScheduleForm }
import javax.inject.{ Inject, Singleton }
import models.Schedule
import play.api.data.Form
import play.api.http.Status.CONFLICT
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.ScheduleRepository
import services.ScheduleService

import scala.util.Try

@Singleton
class ApiScheduleController @Inject() (cc: ControllerComponents, scheduleRepository: ScheduleRepository, scheduleService: ScheduleService)
  extends AbstractController(cc) {

  def add() = Action { implicit request =>
    val error = {
      _: Form[AddScheduleForm] =>
        println("ERROR MESSAGE: NOT MAPPING ADD SCHEDULE FORM AND DATA FROM CLIENT")
        BadRequest(Json.obj("message" -> "Not mapping form client with form server!"))
    }
    val success = {
      data: AddScheduleForm =>
        scheduleService.addSchedule(data) match {
          case true =>
            print(data)
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
          case _ => {
            print(data)
            Conflict(Json.obj("message" -> s"There was a schedule already exist at that period of time!"))
          }
        }
    }
    AddScheduleForm.addScheduleForm.bindFromRequest().fold(error, success)
  }

  def edit() = Action { implicit request =>
    val error = {
      _: Form[EditScheduleForm] =>
        println("ERROR MESSAGE: NOT MAPPING EDIT SCHEDULE FORM AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: EditScheduleForm =>
        println(data)
        scheduleRepository.editSchedule(data) match {
          case 0 => {
            BadRequest(Json.obj("message" -> s"Schedule with id ${data.id} is not update!"))
          }
          case _ =>
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
        }
    }
    EditScheduleForm.editScheduleForm.bindFromRequest().fold(error, success)
  }

  def getSchedule(id: Int) = Action { implicit request =>
    Ok(Json.toJson(scheduleRepository.getSchedule(id)))
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
            scheduleRepository.getAllSchedule().map((listSchedules: List[Schedule]) => {
              val listSearchedSchedules = listSchedules.filter(schedule => schedule.name.toLowerCase().contains(searchName.toLowerCase()) || schedule.date.toLowerCase().contains(searchName.toLowerCase()) || schedule.startAt.toLowerCase().contains(searchName.toLowerCase()))
              val total = listSearchedSchedules.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListSchedule = listSearchedSchedules.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "schedules" -> responseListSchedule,
                "searchingName" -> searchName)
              Ok(obj)
            }).get
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
