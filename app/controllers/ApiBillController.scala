package controllers

import form.{ AddBillForm }
import javax.inject.{ Inject, Singleton }
import models.Bill
import play.api.data.Form
import play.api.http.Status.CONFLICT
import play.api.libs.json.Json
import play.api.mvc.{ AbstractController, ControllerComponents }
import repositories.BillRepository

import scala.util.Try

@Singleton
class ApiBillController @Inject() (cc: ControllerComponents, billRepository: BillRepository)
  extends AbstractController(cc) {

  def add() = Action { implicit request =>
    val error = {
      _: Form[AddBillForm] =>
        println("ERROR MESSAGE: NOT MAPPING ADD BILL FORM AND DATA FROM CLIENT")
        BadRequest(Json.obj("message" -> "Not mapping form client with form server!"))
    }
    val success = {
      data: AddBillForm =>
        billRepository.addBill(data) match {
          case true =>
            print(data)
            val obj = Json.obj(
              "ok" -> true,
              "text" -> Json.obj())
            Ok(obj)
          case _ => {
            print(data)
            Conflict(Json.obj("message" -> s"There was a bill already exist at that period of time!"))
          }
        }
    }
    AddBillForm.addBillForm.bindFromRequest().fold(error, success)
  }

  def getBill(id: Int) = Action { implicit request =>
    Ok(Json.toJson(billRepository.getBill(id)))
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
            billRepository.getAllBill().map((listBills: List[Bill]) => {
              val listSearchedBills = listBills.filter(bill => bill.name.toLowerCase().contains(searchName.toLowerCase()))
              val total = listSearchedBills.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListBill = listSearchedBills.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "bills" -> responseListBill,
                "searchingName" -> searchName)
              Ok(obj)
            }).get
          }
          case _ => {
            val current_page = request.rawQueryString.substring(5).toInt
            val per_page = 10
            billRepository.getAllBill.map((listBills: List[Bill]) => {
              val total = listBills.length
              var total_page = 0
              if (total % per_page == 0) total_page = total / per_page
              else total_page = total / per_page + 1
              val responseListBill = listBills.takeRight(total - (current_page - 1) * per_page).take(per_page)
              val obj = Json.obj(
                "current_page" -> current_page,
                "per_page" -> per_page,
                "total" -> total,
                "total_page" -> total_page,
                "bills" -> responseListBill)
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
        billRepository.deleteBill(id).map((result: Int) => {
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
