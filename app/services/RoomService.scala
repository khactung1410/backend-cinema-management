package services
import form.{ AddMovieForm, AddRoomForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.Schedule
import repositories.{ RoomRepository, ScheduleRepository, SeatRepository, SeatStatusRepository }
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class RoomService @Inject() (scheduleRepository: ScheduleRepository, roomRepository: RoomRepository, seatRepository: SeatRepository, seatStatusRepository: SeatStatusRepository) {

  def addRoom(data: AddRoomForm): Boolean = {
    roomRepository.addRoom(data) match {
      case true => {
        true
      }
      case _ => { // đi tạo các seat cho phòng

        val room = roomRepository.getRoomByName(data.name).get //lấy phòng sau khi tạo(có id)
        println(room)
        val nameRow = Array("A", "B", "C", "D", "E", "F", "G", "H", "I", "K")
        val totalRow = if (room.totalSeat.toInt % 10 == 0) room.totalSeat.toInt / 10 else (room.totalSeat.toInt / 10 + 1)
        for (i <- 1 to totalRow) {
          if ((i == totalRow) && (room.totalSeat.toInt < 10 * totalRow)) { //hàng cuối cùng có số ghế bị lẻ
            for (j <- 1 to (room.totalSeat.toInt % 10)) {
              val nameSeat = nameRow(i - 1) + j.toString
              seatRepository.addSeat(room.id, nameSeat)
            }
          } else { //các hàng có 10 ghế
            for (j <- 1 to 10) {
              val nameSeat = nameRow(i - 1) + j.toString
              seatRepository.addSeat(room.id, nameSeat)
            }
          }
        }
        false
      }
    }
  }
}
