package securityControllers

import javax.inject._
import scala.concurrent.ExecutionContext
import play.api.mvc._
import org.pac4j.core.profile.CommonProfile
import org.pac4j.play.scala.{Security, SecurityComponents}

import play.api.Logger

@Singleton
class SecuredController @Inject()(
    val securityComponents: SecurityComponents
)(implicit ec: ExecutionContext)
  extends Security[CommonProfile] {
  
  private val logger = Logger(this.getClass)

  override protected def controllerComponents: SecurityComponents = securityComponents

  def index: Action[AnyContent] =
    Secure("SAML2Client") { request =>
    logger.info("Entered Secure block")
      val result: Result = request.profiles.headOption match {
        case Some(profile) =>
          logger.info(s"Authenticated user: ${profile.getUsername}")
          val username = Option(profile.getUsername).getOrElse("Unknown user")
          Results.Ok(s"Hello, $username")
        case None =>
          logger.warn("No profile found")
          Results.Unauthorized("No profile found")
      }
      result
    }

  def logout: Action[AnyContent] =
    Action { Results.Redirect("/").withNewSession }
}