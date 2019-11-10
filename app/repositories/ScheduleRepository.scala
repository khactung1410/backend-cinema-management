package repositories
import form.{ AddMovieForm, EditMovieForm }
import javax.inject.Singleton
import models.Schedule
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class ScheduleRepository {

  def getAllSchedule(): Try[List[Schedule]] =
    Try {
      Schedule.findAll()
    }

  def getSchedule(id: Int): Seq[Schedule] = {
    Schedule.findAllByIds(id)
  }

  def deleteSchedule(id: Int): Try[Int] = {
    Try {
      Schedule.deleteById(id)
    }
  }
}
