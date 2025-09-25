// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHelloController HelloController = new controllers.ReverseHelloController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseProfileController ProfileController = new controllers.ReverseProfileController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCallbackRouter CallbackRouter = new controllers.ReverseCallbackRouter(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSecuredController SecuredController = new controllers.ReverseSecuredController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHelloController HelloController = new controllers.javascript.ReverseHelloController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseProfileController ProfileController = new controllers.javascript.ReverseProfileController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCallbackRouter CallbackRouter = new controllers.javascript.ReverseCallbackRouter(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSecuredController SecuredController = new controllers.javascript.ReverseSecuredController(RoutesPrefix.byNamePrefix());
  }

}
