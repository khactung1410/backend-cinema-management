package services
import form.{ AddMovieForm, AddScheduleForm, EditMovieForm }
import javax.inject.{ Inject, Singleton }
import models.SeatStatus
import repositories.{ RoomRepository, ScheduleRepository, SeatRepository, SeatStatusRepository }
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class SeatStatusService @Inject() (scheduleRepository: ScheduleRepository, roomRepository: RoomRepository, seatRepository: SeatRepository, seatStatusRepository: SeatStatusRepository) {

  def getBySchedule(idSchedule: Int): List[SeatStatus] = {
    val schedule = scheduleRepository.getSchedule(idSchedule)(0)
    println(schedule)
    seatStatusRepository.getSeatStatus(schedule.idRoom, schedule.startAt, schedule.date).map((listSeatStatus: List[SeatStatus]) => {
      listSeatStatus
    }).get
  }
}
