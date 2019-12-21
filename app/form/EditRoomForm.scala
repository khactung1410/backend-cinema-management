package form

import play.api.data.Form
import play.api.data.Forms._

case class EditRoomForm(id: String, name: String, totalSeat: String, square: String, location: String, typeRoom: String, updateAt: String)
object EditRoomForm {
  val editRoomForm: Form[EditRoomForm] = Form(
    mapping(
      "id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "totalSeat" -> nonEmptyText,
      "square" -> nonEmptyText,
      "location" -> nonEmptyText,
      "typeRoom" -> nonEmptyText,
      "updateAt" -> nonEmptyText)(EditRoomForm.apply)(EditRoomForm.unapply))
}