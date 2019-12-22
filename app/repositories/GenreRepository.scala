package repositories
import form.{ AddGenreForm, EditGenreForm }
import javax.inject.Singleton
import models.Genre
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class GenreRepository {

  def getAllGenre(): Try[List[Genre]] =
    Try {
      Genre.findAll().reverse
    }

  def getGenre(id: Int): Seq[Genre] = {
    Genre.findAllByIds(id)
  }

  def deleteGenre(id: Int): Try[Int] = {
    Try {
      Genre.deleteById(id)
    }
  }

  def getGenreByName(name: String): Try[Genre] = {
    Try {
      Genre.findBy(sqls.eq(Genre.defaultAlias.name, name)).get
    }
  }

  def addGenre(data: AddGenreForm): Boolean = {
    this.getGenreByName(data.name).map(_ => true)
      .recover {
        case _ =>
          {
            Genre.createWithAttributes(
              Symbol("name") -> data.name,
              Symbol("country") -> data.country,
              Symbol("totalMovieHas") -> data.totalMovieHas,
              Symbol("language") -> data.language)
          }
          false
      }.get
  }

  def editGenre(data: EditGenreForm): Int = {
    println("tung: " + data)
    Genre.updateById(data.id.toInt).withAttributes(
      Symbol("name") -> data.name,
      Symbol("country") -> data.country,
      Symbol("language") -> data.language)
  }
}
