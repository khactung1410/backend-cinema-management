package services
import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.Schedule
import repositories.{ ScheduleRepository, SeatRepository }
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class ScheduleService @Inject() (scheduleRepository: ScheduleRepository, seatRepository: SeatRepository) {

  def addSchedule(data: AddScheduleForm): Boolean = {
    scheduleRepository.addSchedule(data) match {
      case Some(newSchedule) => {
        val idRoom = newSchedule.idRoom.toInt
        val listSeat = seatRepository.getAllSeat(idRoom).get

        true
      }
      case None => false
    }
  }
}
