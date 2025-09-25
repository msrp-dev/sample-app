package modules

import play.api.inject.{Binding, Module}
import play.api.{Configuration, Environment}
import org.pac4j.core.config.Config
import org.pac4j.play.CallbackController
import org.pac4j.play.scala.SecurityComponents
import org.pac4j.core.context.session.SessionStore
import org.pac4j.play.store.PlayCacheSessionStore

class SecurityModule extends Module {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = {
    Seq(
      bind[SecurityConfigFactory].toProvider[SecurityConfigFactoryProvider],
      bind[Config].toProvider[ConfigProvider],
      bind[CallbackController].toProvider[CallbackControllerProvider],
      bind[SecurityComponents].toProvider[SecurityComponentsProvider],
      bind[SessionStore].to[PlayCacheSessionStore]
    )
  }
}