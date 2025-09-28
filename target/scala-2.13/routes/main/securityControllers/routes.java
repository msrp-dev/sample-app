// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package securityControllers;

import router.RoutesPrefix;

public class routes {
  
  public static final securityControllers.ReverseSecuredController SecuredController = new securityControllers.ReverseSecuredController(RoutesPrefix.byNamePrefix());
  public static final securityControllers.ReverseCallbackRouter CallbackRouter = new securityControllers.ReverseCallbackRouter(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final securityControllers.javascript.ReverseSecuredController SecuredController = new securityControllers.javascript.ReverseSecuredController(RoutesPrefix.byNamePrefix());
    public static final securityControllers.javascript.ReverseCallbackRouter CallbackRouter = new securityControllers.javascript.ReverseCallbackRouter(RoutesPrefix.byNamePrefix());
  }

}
