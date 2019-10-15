// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Wed Oct 16 01:53:52 ICT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

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
