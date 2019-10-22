// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Tue Oct 22 21:11:33 ICT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseApiMovieController ApiMovieController = new controllers.ReverseApiMovieController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApiController ApiController = new controllers.ReverseApiController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseApiMovieController ApiMovieController = new controllers.javascript.ReverseApiMovieController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApiController ApiController = new controllers.javascript.ReverseApiController(RoutesPrefix.byNamePrefix());
  }

}
