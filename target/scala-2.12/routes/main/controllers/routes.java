// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/Tung_DK/Documents/Training/Code/backend-cinema-management/conf/routes
// @DATE:Mon Oct 21 11:01:16 ICT 2019
=======
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Mon Oct 21 23:47:29 ICT 2019
>>>>>>> f5f41015ae1ebbd5e8ed850463a67064fbffea68

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
