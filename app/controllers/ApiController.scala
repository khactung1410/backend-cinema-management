package controllers

import form.LoginForm
import javax.inject.{ Inject, Singleton }
import models.User
import play.api.data.Form
import play.api.i18n.Messages.Message
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents, Result }
import repositories.DataRepository

import scala.util.Try

@Singleton
class ApiController @Inject() (cc: ControllerComponents, dataRepository: DataRepository)
  extends AbstractController(cc) {
  // Create a simple 'ping' endpoint for now, so that we
  // can get up and running with a basic implementation
  def ping = Action { implicit request =>
    Ok("Hello, Scala!")
  }

  def getPost(postId: Int) = Action { implicit request =>
    dataRepository.getPost(postId) map { post =>
      Ok(Json.toJson(post))
    } getOrElse (NotFound)
  }

  def getComments(postId: Int) = Action { implicit request =>
    Ok(Json.toJson(dataRepository.getComments(postId)))
  }
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
        val filterUsers = dataRepository.getAllUser().filter(user => user.username == data.username && user.password == data.password)
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
        } else Ok("username or pass word is incorrect")
    }
    LoginForm.loginForm.bindFromRequest().fold(error, success)
  }
}