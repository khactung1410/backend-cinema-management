package models

import play.api.libs.json.Json
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class User(id: Int, username: String, password: String, role: String, fullname: String, address: String, phone: String)

object User extends SkinnyCRUDMapper[User] {
  implicit val format = Json.format[User]
  override lazy val defaultAlias = createAlias("u")
  override lazy val tableName = "user"

  override def extract(rs: WrappedResultSet, n: ResultName[User]): User = new User(
    id = rs.get(n.id),
    username = rs.get(n.username),
    password = rs.get(n.password),
    role = rs.get(n.role),
    fullname = rs.get(n.fullname),
    address = rs.get(n.address),
    phone = rs.get(n.phone))
}

