package filters

import play.api.mvc._
import play.filters.csrf.CSRFFilter
import javax.inject._

import scala.concurrent.ExecutionContext

@Singleton
class CustomCSRFFilter @Inject()(
  csrfFilter: CSRFFilter
)(implicit ec: ExecutionContext) extends EssentialFilter {

  override def apply(next: EssentialAction): EssentialAction = EssentialAction { request =>
    val path = request.uri.split('?').head
    if (path == "/callback") {
      next(request) // CSRFチェックをスキップ
    } else {
      csrfFilter.apply(next)(request) // 通常のCSRFチェックを適用
    }
  }
}