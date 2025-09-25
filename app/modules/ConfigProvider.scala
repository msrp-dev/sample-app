package modules

import javax.inject._
import org.pac4j.core.config.Config

@Singleton
class ConfigProvider @Inject()(factory: SecurityConfigFactory) extends Provider[Config] {
  override def get(): Config = factory.getConfig
}