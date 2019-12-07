package controllers

import form.{ LoginForm, RegisterForm }
import javax.inject.{ Inject, Singleton }
import models.User
import org.mindrot.jbcrypt.BCrypt
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.UserRepository

@Singleton
class ApiController @Inject() (cc: ControllerComponents, userRepository: UserRepository)
  extends AbstractController(cc) {
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
            userRepository.getAllUser().map((listUsers: List[User]) => {
              val listSearchedUsers = listUsers.filter(user => user.username.toLowerCase().contains(searchName.toLowerCase()))
              val total = listSearchedUsers.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListUser = listSearchedUsers.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "users" -> responseListUser,
                "allUsers" -> listUsers,
                "searchingName" -> searchName)
              Ok(obj)
            }).get
          }
          case _ => {
            val current_page = request.rawQueryString.substring(5).toInt
            val per_page = 10
            userRepository.getAllUser.map((listUsers: List[User]) => {
              val total = listUsers.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListUser = listUsers.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "users" -> responseListUser,
                "allUsers" -> listUsers)
              Ok(obj)
            }).getOrElse(BadRequest)
          }
        }
      } else {
        BadRequest(Json.obj("message" -> "You're not login!"))
      }
    }
  }
  def getUser(id: Int) = Action { implicit request =>
    Ok(Json.toJson(userRepository.getUser(id)))
  }

  def login() = Action { implicit request =>
    val error = {
      _: Form[LoginForm] =>
        println("ERROR MESSAGE: NOT MAPPING FORM LOGIN AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: LoginForm =>
        val filterUsers = userRepository.getAllUser().map(listUser => listUser.filter(user => user.username == data.username && BCrypt.checkpw(data.password, user.password))).get
        if (filterUsers.length > 0) {
          val user = filterUsers(0)
          val obj = Json.obj(
            "ok" -> true,
            "text" -> Json.obj(
              "id" -> user.id,
              "username" -> user.username,
              "password" -> user.password,
              "role" -> user.role,
              "fullname" -> user.fullname,
              "address" -> user.address,
              "phone" -> user.phone,
              "token" -> "fake-jwt-token"))
          println(obj)
          Ok(obj)
        } else {
          val obj = Json.obj("message" -> "Username or Password is incorrect!")
          BadRequest(obj)
        }
    }
    LoginForm.loginForm.bindFromRequest().fold(error, success)
  }

  def register() = Action { implicit request =>
    val error = {
      _: Form[RegisterForm] =>
        println("ERROR MESSAGE: NOT MAPPING FORM REGISTER AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: RegisterForm =>
        userRepository.registerUser(data) match {
          case true => {
            BadRequest(Json.obj("message" -> s"Username ${data.userName} is already taken!"))
          }
          case _ =>
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
        }
    }
    RegisterForm.registerForm.bindFromRequest().fold(error, success)
  }
}