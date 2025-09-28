package securityModules

import javax.inject._
import org.pac4j.play.CallbackController

@Singleton
class CallbackControllerProvider @Inject()(securityConfigFactory: SecurityConfigFactory) extends Provider[CallbackController] {
  override def get(): CallbackController = {
    val controller = securityConfigFactory.getCallbackController
    controller
  }
}