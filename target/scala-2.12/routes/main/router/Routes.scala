// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Sun Oct 13 22:03:36 ICT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ApiController_0: controllers.ApiController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ApiController_0: controllers.ApiController
  ) = this(errorHandler, ApiController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApiController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/ping""", """controllers.ApiController.ping"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/""" + "$" + """postId<[^/]+>""", """controllers.ApiController.getPost(postId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/""" + "$" + """postId<[^/]+>/comments""", """controllers.ApiController.getComments(postId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/""" + "$" + """id<[^/]+>""", """controllers.ApiController.getUser(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/login""", """controllers.ApiController.login()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ApiController_ping0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/ping")))
  )
  private[this] lazy val controllers_ApiController_ping0_invoker = createInvoker(
    ApiController_0.ping,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "ping",
      Nil,
      "GET",
      this.prefix + """api/ping""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ApiController_getPost1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApiController_getPost1_invoker = createInvoker(
    ApiController_0.getPost(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getPost",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """api/post/""" + "$" + """postId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ApiController_getComments2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("postId", """[^/]+""",true), StaticPart("/comments")))
  )
  private[this] lazy val controllers_ApiController_getComments2_invoker = createInvoker(
    ApiController_0.getComments(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getComments",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """api/post/""" + "$" + """postId<[^/]+>/comments""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_ApiController_getUser3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApiController_getUser3_invoker = createInvoker(
    ApiController_0.getUser(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getUser",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """api/user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_ApiController_login4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/login")))
  )
  private[this] lazy val controllers_ApiController_login4_invoker = createInvoker(
    ApiController_0.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "login",
      Nil,
      "POST",
      this.prefix + """api/user/login""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ApiController_ping0_route(params@_) =>
      call { 
        controllers_ApiController_ping0_invoker.call(ApiController_0.ping)
      }
  
    // @LINE:7
    case controllers_ApiController_getPost1_route(params@_) =>
      call(params.fromPath[Int]("postId", None)) { (postId) =>
        controllers_ApiController_getPost1_invoker.call(ApiController_0.getPost(postId))
      }
  
    // @LINE:8
    case controllers_ApiController_getComments2_route(params@_) =>
      call(params.fromPath[Int]("postId", None)) { (postId) =>
        controllers_ApiController_getComments2_invoker.call(ApiController_0.getComments(postId))
      }
  
    // @LINE:9
    case controllers_ApiController_getUser3_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ApiController_getUser3_invoker.call(ApiController_0.getUser(id))
      }
  
    // @LINE:10
    case controllers_ApiController_login4_route(params@_) =>
      call { 
        controllers_ApiController_login4_invoker.call(ApiController_0.login())
      }
  }
}
