package modules

import javax.inject._
import play.cache.SyncCacheApi
import play.libs.concurrent.HttpExecutionContext
import modules.SecurityConfigFactory
import play.api.Configuration

@Singleton
class SecurityConfigFactoryProvider @Inject()(cacheApi: SyncCacheApi, httpExecutionContext: HttpExecutionContext, apConf: Configuration) extends Provider[SecurityConfigFactory] {
  override def get(): SecurityConfigFactory = new SecurityConfigFactory(cacheApi, httpExecutionContext, apConf)
}