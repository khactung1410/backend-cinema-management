// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Tung_DK/Documents/Training/Code/backend-cinema-management/conf/routes
// @DATE:Tue Oct 22 16:08:15 ICT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:13
  class ReverseApiMovieController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiMovieController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/movies"})
        }
      """
    )
  
    // @LINE:13
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiMovieController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/movie/add"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def ping: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.ping",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ping"})
        }
      """
    )
  
    // @LINE:10
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.getUser",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/register"})
        }
      """
    )
  
    // @LINE:11
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/login"})
        }
      """
    )
  
  }


}
