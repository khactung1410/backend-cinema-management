package controllers

import form.{ LoginForm, RegisterForm }
import javax.inject.{ Inject, Singleton }
import models.User
import org.mindrot.jbcrypt.BCrypt
import play.api.data.Form
import play.api.i18n.Messages.Message
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents, Result }
import repositories.DataRepository

import scala.util.Try

@Singleton
class ApiController @Inject() (cc: ControllerComponents, dataRepository: DataRepository)
  extends AbstractController(cc) {

  def getUser(id: Int) = Action { implicit request =>
    Ok(Json.toJson(dataRepository.getUser(id)))
  }

  def login() = Action { implicit request =>
    val error = {
      _: Form[LoginForm] =>
        println("ERROR MESSAGE: NOT MAPPING FORM LOGIN AND DATA FROM CLIENT")
        BadRequest
    }
    val success = {
      data: LoginForm =>
        val filterUsers = dataRepository.getAllUser().filter(user => user.username == data.username && BCrypt.checkpw(data.password, user.password))
        if (filterUsers.length > 0) {
          val user = filterUsers(0)
          val obj = Json.obj(
            "ok" -> true,
            "text" -> Json.obj(
              "id" -> user.id,
              "username" -> user.username,
              "password" -> user.password,
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
        dataRepository.registerUser(data) match {
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