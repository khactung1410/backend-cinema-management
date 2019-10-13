// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Sun Oct 13 22:03:36 ICT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getUser(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:7
    def getPost(postId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/post/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("postId", postId)))
    }
  
    // @LINE:8
    def getComments(postId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/post/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("postId", postId)) + "/comments")
    }
  
    // @LINE:6
    def ping(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/ping")
    }
  
    // @LINE:10
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/login")
    }
  
  }


}
