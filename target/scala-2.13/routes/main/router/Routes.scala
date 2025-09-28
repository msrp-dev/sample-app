// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_5: controllers.HomeController,
  // @LINE:10
  Assets_4: controllers.Assets,
  // @LINE:13
  HelloController_1: controllers.HelloController,
  // @LINE:17
  SecuredController_3: securityControllers.SecuredController,
  // @LINE:19
  CallbackRouter_2: securityControllers.CallbackRouter,
  // @LINE:22
  ProfileController_0: controllers.ProfileController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_5: controllers.HomeController,
    // @LINE:10
    Assets_4: controllers.Assets,
    // @LINE:13
    HelloController_1: controllers.HelloController,
    // @LINE:17
    SecuredController_3: securityControllers.SecuredController,
    // @LINE:19
    CallbackRouter_2: securityControllers.CallbackRouter,
    // @LINE:22
    ProfileController_0: controllers.ProfileController
  ) = this(errorHandler, HomeController_5, Assets_4, HelloController_1, SecuredController_3, CallbackRouter_2, ProfileController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_5, Assets_4, HelloController_1, SecuredController_3, CallbackRouter_2, ProfileController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello""", """controllers.HelloController.hello()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello""", """controllers.HelloController.helloJson()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """secured""", """securityControllers.SecuredController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """callback""", """securityControllers.CallbackRouter.callback"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """callback""", """securityControllers.CallbackRouter.callback"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.ProfileController.profile"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """securityControllers.SecuredController.logout"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_5.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HelloController_hello2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello")))
  )
  private[this] lazy val controllers_HelloController_hello2_invoker = createInvoker(
    HelloController_1.hello(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloController",
      "hello",
      Nil,
      "GET",
      this.prefix + """hello""",
      """ Hello""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HelloController_helloJson3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello")))
  )
  private[this] lazy val controllers_HelloController_helloJson3_invoker = createInvoker(
    HelloController_1.helloJson(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloController",
      "helloJson",
      Nil,
      "POST",
      this.prefix + """hello""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val securityControllers_SecuredController_index4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("secured")))
  )
  private[this] lazy val securityControllers_SecuredController_index4_invoker = createInvoker(
    SecuredController_3.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "securityControllers.SecuredController",
      "index",
      Nil,
      "GET",
      this.prefix + """secured""",
      """ SAML""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val securityControllers_CallbackRouter_callback5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("callback")))
  )
  private[this] lazy val securityControllers_CallbackRouter_callback5_invoker = createInvoker(
    CallbackRouter_2.callback,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "securityControllers.CallbackRouter",
      "callback",
      Nil,
      "GET",
      this.prefix + """callback""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val securityControllers_CallbackRouter_callback6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("callback")))
  )
  private[this] lazy val securityControllers_CallbackRouter_callback6_invoker = createInvoker(
    CallbackRouter_2.callback,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "securityControllers.CallbackRouter",
      "callback",
      Nil,
      "POST",
      this.prefix + """callback""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ProfileController_profile7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_ProfileController_profile7_invoker = createInvoker(
    ProfileController_0.profile,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProfileController",
      "profile",
      Nil,
      "GET",
      this.prefix + """profile""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val securityControllers_SecuredController_logout8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val securityControllers_SecuredController_logout8_invoker = createInvoker(
    SecuredController_3.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "securityControllers.SecuredController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_5.index())
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:13
    case controllers_HelloController_hello2_route(params@_) =>
      call { 
        controllers_HelloController_hello2_invoker.call(HelloController_1.hello())
      }
  
    // @LINE:14
    case controllers_HelloController_helloJson3_route(params@_) =>
      call { 
        controllers_HelloController_helloJson3_invoker.call(HelloController_1.helloJson())
      }
  
    // @LINE:17
    case securityControllers_SecuredController_index4_route(params@_) =>
      call { 
        securityControllers_SecuredController_index4_invoker.call(SecuredController_3.index)
      }
  
    // @LINE:19
    case securityControllers_CallbackRouter_callback5_route(params@_) =>
      call { 
        securityControllers_CallbackRouter_callback5_invoker.call(CallbackRouter_2.callback)
      }
  
    // @LINE:20
    case securityControllers_CallbackRouter_callback6_route(params@_) =>
      call { 
        securityControllers_CallbackRouter_callback6_invoker.call(CallbackRouter_2.callback)
      }
  
    // @LINE:22
    case controllers_ProfileController_profile7_route(params@_) =>
      call { 
        controllers_ProfileController_profile7_invoker.call(ProfileController_0.profile)
      }
  
    // @LINE:23
    case securityControllers_SecuredController_logout8_route(params@_) =>
      call { 
        securityControllers_SecuredController_logout8_invoker.call(SecuredController_3.logout)
      }
  }
}
