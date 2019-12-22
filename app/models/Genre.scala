package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class Genre(id: Int, name: String, country: String, totalMovieHas: String, language: String)

object Genre extends SkinnyCRUDMapper[Genre] {
  implicit val format = Json.format[Genre]
  override lazy val defaultAlias = createAlias("g")
  override lazy val tableName = "genre"

  override def extract(rs: WrappedResultSet, g: ResultName[Genre]): Genre = new Genre(
    id = rs.get(g.id),
    name = rs.get(g.name),
    country = rs.get(g.country),
    totalMovieHas = rs.get(g.totalMovieHas),
    language = rs.get(g.language))
}