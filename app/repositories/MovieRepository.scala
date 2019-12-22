package repositories
import form.{ AddMovieForm, EditMovieForm }
import javax.inject.Singleton
import models.Movie
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class MovieRepository {

  def getMovieByName(name: String): Try[Movie] = {
    Try {
      Movie.findBy(sqls.eq(Movie.defaultAlias.name, name)).get
    }
  }

  def addMovie(data: AddMovieForm, filename: String): Boolean = {
    this.getMovieByName(data.name).map(_ => true)
      .recover {
        case _ =>
          {
            Movie.createWithAttributes(
              Symbol("name") -> data.name,
              Symbol("genre") -> data.genre,
              Symbol("director") -> data.director,
              Symbol("publicYear") -> data.publicYear,
              Symbol("description") -> data.description,
              Symbol("trailer") -> data.trailer,
              Symbol("poster") -> filename)
          }
          false
      }.get
  }

  def editMovie(data: EditMovieForm): Int = {
    println("tung: " + data)
    Movie.updateById(data.id.toInt).withAttributes(
      Symbol("name") -> data.name,
      Symbol("genre") -> data.genre,
      Symbol("director") -> data.director,
      Symbol("publicYear") -> data.publicYear,
      Symbol("description") -> data.description)
  }

  def getAllMovie(): Try[List[Movie]] =
    Try {
      Movie.findAll().reverse
    }

  def getMovie(id: Int): Seq[Movie] = {
    Movie.findAllByIds(id)
  }

  def deleteMovie(id: Int): Try[Int] = {
    Try {
      Movie.deleteById(id)
    }
  }
}
