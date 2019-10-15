package repositories
import form.RegisterForm
import javax.inject.Singleton
import models.{ Comment, Post, User }
import org.mindrot.jbcrypt.BCrypt
import scalikejdbc.sqls

import scala.util.Try

@Singleton
class DataRepository {
  //  private val posts = Seq(
  //    Post(1, "this is a blog post"),
  //    Post(2, "Another blog post with awesome content"))
  //
  //  private val comments = Seq(
  //    Comment(1, 1, "This is an awesome blog post", "Fantastic Mr Fox"),
  //    Comment(2, 1, "Thanks for the insights", "Jane Doe"),
  //    Comment(3, 2, "Great, thanks for this post", "Joe Bloggs"))
  //
  //  def getPost(postId: Int): Option[Post] = posts.collectFirst {
  //    case p if p.id == postId => p
  //  }
  //
  //  def getComments(postId: Int): Seq[Comment] = comments.collect {
  //    case c if c.postId == postId => c
  //  }
  def getUser(id: Int): Seq[User] = {
    User.findAllByIds(id)
  }

  def getAllUser(): List[User] = User.findAll()

  def getUserByUsername(username: String): Try[User] = {
    Try {
      User.findBy(sqls.eq(User.defaultAlias.username, username)).get
    }
  }
  def registerUser(data: RegisterForm): Boolean = {
    this.getUserByUsername(data.userName).map(_ => true)
      .recover {
        case _ => {
          User.createWithAttributes(
            Symbol("username") -> data.userName,
            Symbol("phone") -> data.phone,
            Symbol("fullname") -> data.fullName,
            Symbol("password") -> data.password,
            Symbol("address") -> data.address)
        }
      }.get
    false
  }
}
