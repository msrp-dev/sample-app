package filters

import javax.inject._
import play.api.http.HttpFilters
import play.filters.csrf.CSRFFilter
import play.filters.headers.SecurityHeadersFilter
import play.filters.hosts.AllowedHostsFilter

@Singleton
class Filters @Inject()(
  customCSRFFilter: CustomCSRFFilter,
  securityHeadersFilter: SecurityHeadersFilter,
  allowedHostsFilter: AllowedHostsFilter
) extends HttpFilters {
  override val filters = Seq(
    allowedHostsFilter,
    securityHeadersFilter,
    customCSRFFilter
  )
}
