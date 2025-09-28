// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:17
package securityControllers.javascript {

  // @LINE:17
  class ReverseSecuredController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "securityControllers.SecuredController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "secured"})
        }
      """
    )
  
    // @LINE:23
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "securityControllers.SecuredController.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseCallbackRouter(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def callback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "securityControllers.CallbackRouter.callback",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "callback"})
          }
        
        }
      """
    )
  
  }


}
