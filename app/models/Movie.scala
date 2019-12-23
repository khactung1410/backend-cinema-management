package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class Movie(id: Int, name: String, genre: String, director: String, publicYear: String, description: String, trailer: String, poster: String)

object Movie extends SkinnyCRUDMapper[Movie] {
  implicit val format = Json.format[Movie]
  override lazy val defaultAlias = createAlias("m")
  override lazy val tableName = "movie"

  override def extract(rs: WrappedResultSet, m: ResultName[Movie]): Movie = new Movie(
    id = rs.get(m.id),
    name = rs.get(m.name),
    genre = rs.get(m.genre),
    director = rs.get(m.director),
    publicYear = rs.get(m.publicYear),
    description = rs.get(m.description),
    trailer = rs.get(m.trailer),
    poster = rs.get(m.poster))
}

