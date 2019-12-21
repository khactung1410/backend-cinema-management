package services
import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.Schedule
import repositories.{ RoomRepository, ScheduleRepository, SeatRepository, SeatStatusRepository }
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class ScheduleService @Inject() (scheduleRepository: ScheduleRepository, roomRepository: RoomRepository, seatRepository: SeatRepository, seatStatusRepository: SeatStatusRepository) {

  def addSchedule(data: AddScheduleForm): Boolean = {
    val room = roomRepository.getRoom(data.idRoom.toInt)(0)
    scheduleRepository.addSchedule(data, room.totalSeat.toInt) match {
      case Some(newSchedule) => {
        val idRoom = newSchedule.idRoom.toInt
        val listSeat = seatRepository.getAllSeatByRoom(idRoom).get
        listSeat.map(seat => {
          seatStatusRepository.addSeatStatus(data, seat)
        })
        true
      }
      case None => false
    }
  }
}
