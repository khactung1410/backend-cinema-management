package controllers

import form.{ AddRoomForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.Room
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.RoomRepository
import services.RoomService

import scala.util.Try

@Singleton
class ApiRoomController @Inject() (cc: ControllerComponents, roomRepository: RoomRepository, roomService: RoomService)
  extends AbstractController(cc) {

  def add() = Action { implicit request =>
    val error = {
      _: Form[AddRoomForm] =>
        println("ERROR MESSAGE: NOT MAPPING ADD ROOM FORM AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: AddRoomForm =>
        roomService.addRoom(data) match {
          case true => {
            print(data)
            BadRequest(Json.obj("message" -> s"Room with name ${data.name} is already taken!"))
          }
          case _ =>
            print(data)
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
        }
    }
    AddRoomForm.addRoomForm.bindFromRequest().fold(error, success)
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
            roomRepository.getAllRoom().map((listRooms: List[Room]) => {
              val listSearchedRooms = listRooms.filter(room => room.name.toLowerCase().contains(searchName.toLowerCase()))
              val total = listSearchedRooms.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListRoom = listSearchedRooms.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "rooms" -> responseListRoom,
                "allRoom" -> listRooms,
                "searchingName" -> searchName)
              Ok(obj)
            }).get
          }
          case _ => {
            val current_page = request.rawQueryString.substring(5).toInt
            val per_page = 10
            roomRepository.getAllRoom.map((listRooms: List[Room]) => {
              val total = listRooms.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListRoom = listRooms.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "rooms" -> responseListRoom,
                "allRoom" -> listRooms)
              Ok(obj)
            }).getOrElse(BadRequest)
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
        roomRepository.deleteRoom(id).map((result: Int) => {
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