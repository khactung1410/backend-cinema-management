package repositories
import form.AddMovieForm
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
  def addMovie(data: AddMovieForm): Boolean = {
    this.getMovieByName(data.name).map(_ => true)
      .recover {
        case _ =>
          {
            Movie.createWithAttributes(
              Symbol("name") -> data.name,
              Symbol("genre") -> data.genre,
              Symbol("director") -> data.director,
              Symbol("publicYear") -> data.publicYear,
              Symbol("description") -> data.description)
          }
          false
      }.get
  }

  def getAllMovie(): Try[List[Movie]] =
    Try {
      Movie.findAll()
    }
  def deleteMovie(id: Int): Try[Int] = {
    Try {
      Movie.deleteById(id)
    }
  }
}
