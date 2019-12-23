package repositories
import form.{ EditUserForm, RegisterForm }
import javax.inject.Singleton
import models.User
import org.mindrot.jbcrypt.BCrypt
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class UserRepository {
  def getUser(id: Int): Seq[User] = {
    User.findAllByIds(id)
  }

  def getAllUser(): Try[List[User]] =
    Try {
      User.findAll().reverse
    }

  def getUserByUsername(username: String): Try[User] = {
    Try {
      User.findBy(sqls.eq(User.defaultAlias.username, username)).get
    }
  }

  def editUser(data: EditUserForm): Int = {
    println("tung: " + data)
    User.updateById(data.id.toInt).withAttributes(
      Symbol("fullname") -> data.fullname,
      Symbol("address") -> data.address,
      Symbol("phone") -> data.phone,
      Symbol("username") -> data.username,
      Symbol("role") -> data.role)
  }

  def registerUser(data: RegisterForm): Boolean = {
    this.getUserByUsername(data.userName).map(_ => true)
      .recover {
        case _ =>
          {
            User.createWithAttributes(
              Symbol("username") -> data.userName,
              Symbol("phone") -> data.phone,
              Symbol("fullname") -> data.fullName,
              Symbol("password") -> BCrypt.hashpw(data.password, BCrypt.gensalt(10)),
              Symbol("role") -> data.role,
              Symbol("address") -> data.address)
          }
          false
      }.get
  }

  def deleteUser(id: Int): Try[Int] = {
    Try {
      User.deleteById(id)
    }
  }
}
