package form

import play.api.data.Form
import play.api.data.Forms._

case class AddRoomForm(name: String, totalSeat: String, square: String, location: String, typeRoom: String, createAt: String, updateAt: String)
object AddRoomForm {
  val addRoomForm: Form[AddRoomForm] = Form(
    mapping(
      "name" -> nonEmptyText,
      "totalSeat" -> nonEmptyText,
      "square" -> nonEmptyText,
      "location" -> nonEmptyText,
      "typeRoom" -> nonEmptyText,
      "createAt" -> nonEmptyText,
      "updateAt" -> nonEmptyText)(AddRoomForm.apply)(AddRoomForm.unapply))
}