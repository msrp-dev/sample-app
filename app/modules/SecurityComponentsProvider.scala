package modules

import javax.inject._
import play.api.mvc.{ControllerComponents, BodyParsers}
import org.pac4j.core.config.Config
import org.pac4j.core.context.session.SessionStore
import org.pac4j.play.scala.{SecurityComponents, DefaultSecurityComponents}

import play.api.Logger

@Singleton
class SecurityComponentsProvider @Inject()(
    configFactory: SecurityConfigFactory,
    controllerComponents: ControllerComponents,
    bodyParsers: BodyParsers.Default
) extends Provider[SecurityComponents] {

  private val logger = Logger(this.getClass)

  override def get(): SecurityComponents = {
    val config: Config = configFactory.getConfig
    
    val sessionStore: SessionStore = config.getSessionStore
    if (sessionStore == null) {
      logger.error("SessionStore is null in pac4j Config")
      throw new RuntimeException("SessionStore is not set")
    }
    logger.info("SecurityComponents initialized successfully")
    
    new DefaultSecurityComponents(sessionStore, config, bodyParsers, controllerComponents)
  }
}