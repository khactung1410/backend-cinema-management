// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/Tung_DK/Documents/Training/Code/backend-cinema-management/conf/routes
// @DATE:Mon Oct 21 11:01:16 ICT 2019
=======
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Mon Oct 21 23:47:29 ICT 2019
>>>>>>> f5f41015ae1ebbd5e8ed850463a67064fbffea68

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:13
  class ReverseApiMovieController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/movie/add")
    }
  
  }

  // @LINE:6
  class ReverseApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def ping(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/ping")
    }
  
    // @LINE:10
    def getUser(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:12
    def register(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/register")
    }
  
    // @LINE:11
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/login")
    }
  
  }


}
