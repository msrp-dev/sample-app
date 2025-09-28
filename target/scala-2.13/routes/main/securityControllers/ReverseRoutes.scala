// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:17
package securityControllers {

  // @LINE:17
  class ReverseSecuredController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def index: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "secured")
    }
  
    // @LINE:23
    def logout: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
  }

  // @LINE:19
  class ReverseCallbackRouter(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def callback: Call = {
    
      () match {
      
        // @LINE:19
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "callback")
      
      }
    
    }
  
  }


}
