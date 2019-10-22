// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Tung_DK/Documents/Training/Code/backend-cinema-management/conf/routes
// @DATE:Tue Oct 22 16:08:15 ICT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ApiController_0: controllers.ApiController,
  // @LINE:13
  ApiMovieController_1: controllers.ApiMovieController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ApiController_0: controllers.ApiController,
    // @LINE:13
    ApiMovieController_1: controllers.ApiMovieController
  ) = this(errorHandler, ApiController_0, ApiMovieController_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApiController_0, ApiMovieController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/ping""", """controllers.ApiController.ping"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/""" + "$" + """id<[^/]+>""", """controllers.ApiController.getUser(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/login""", """controllers.ApiController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/register""", """controllers.ApiController.register()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/movie/add""", """controllers.ApiMovieController.add()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/movies""", """controllers.ApiMovieController.getAll()"""),
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

  // @LINE:10
  private[this] lazy val controllers_ApiController_getUser1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApiController_getUser1_invoker = createInvoker(
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

  // @LINE:11
  private[this] lazy val controllers_ApiController_login2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/login")))
  )
  private[this] lazy val controllers_ApiController_login2_invoker = createInvoker(
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

  // @LINE:12
  private[this] lazy val controllers_ApiController_register3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/register")))
  )
  private[this] lazy val controllers_ApiController_register3_invoker = createInvoker(
    ApiController_0.register(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "register",
      Nil,
      "POST",
      this.prefix + """api/user/register""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_ApiMovieController_add4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/movie/add")))
  )
  private[this] lazy val controllers_ApiMovieController_add4_invoker = createInvoker(
    ApiMovieController_1.add(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiMovieController",
      "add",
      Nil,
      "POST",
      this.prefix + """api/movie/add""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_ApiMovieController_getAll5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/movies")))
  )
  private[this] lazy val controllers_ApiMovieController_getAll5_invoker = createInvoker(
    ApiMovieController_1.getAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiMovieController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """api/movies""",
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
  
    // @LINE:10
    case controllers_ApiController_getUser1_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ApiController_getUser1_invoker.call(ApiController_0.getUser(id))
      }
  
    // @LINE:11
    case controllers_ApiController_login2_route(params@_) =>
      call { 
        controllers_ApiController_login2_invoker.call(ApiController_0.login())
      }
  
    // @LINE:12
    case controllers_ApiController_register3_route(params@_) =>
      call { 
        controllers_ApiController_register3_invoker.call(ApiController_0.register())
      }
  
    // @LINE:13
    case controllers_ApiMovieController_add4_route(params@_) =>
      call { 
        controllers_ApiMovieController_add4_invoker.call(ApiMovieController_1.add())
      }
  
    // @LINE:14
    case controllers_ApiMovieController_getAll5_route(params@_) =>
      call { 
        controllers_ApiMovieController_getAll5_invoker.call(ApiMovieController_1.getAll())
      }
  }
}
