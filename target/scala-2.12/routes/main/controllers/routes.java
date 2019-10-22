// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Tung_DK/Documents/Training/Code/backend-cinema-management/conf/routes
// @DATE:Mon Oct 21 11:01:16 ICT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseApiController ApiController = new controllers.ReverseApiController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseApiController ApiController = new controllers.javascript.ReverseApiController(RoutesPrefix.byNamePrefix());
  }

}
