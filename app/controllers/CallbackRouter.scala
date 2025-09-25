package controllers

import javax.inject.Inject
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import play.api.Logging
import org.pac4j.play.PlayWebContext
import org.pac4j.core.context.session.SessionStore
import org.pac4j.core.engine.DefaultCallbackLogic
import org.pac4j.core.config.Config
import scala.jdk.CollectionConverters._
import org.pac4j.core.profile.ProfileManager
import org.pac4j.core.profile.CommonProfile
import play.api.Configuration


class CallbackRouter @Inject() (
  val controllerComponents: ControllerComponents,
  config: Config,
  sessionStore: SessionStore,  
  callbackController: org.pac4j.play.CallbackController,
  apConf: Configuration
  )(implicit ec: ExecutionContext) extends BaseController with Logging {

  def callback: Action[AnyContent] = Action.async { request =>
    val webContext = new PlayWebContext(request.asInstanceOf[RequestHeader])

    val callbackLogic = new DefaultCallbackLogic()

    try {
        val rawResult = callbackLogic.perform(
          webContext,
          sessionStore,
          config,
          config.getHttpActionAdapter,
          callbackController.getDefaultUrl,    // 認証成功後にリダイレクトするパス
          true,                                // SAMLアサーションから取得した情報(ユーザ名等)をセッションに保存する場合は「true」
          null                                 // dfaultClient（使用するクライアント名（例："SAML2Client"）。null の場合は、リクエストから自動判定）
        )

        // プロファイルからユーザIDを取得
        val profileManager = new ProfileManager(webContext, sessionStore)
        val profiles = profileManager.getProfiles()
        val profileOpt: Option[CommonProfile] = profiles.asScala.collectFirst {
          case cp: CommonProfile => cp
        }

        // ユーザIDをセッションに格納し、「認証後のリダイレクト先」にリダイレクト
        val result: Future[Result] = profileOpt match {
          case Some(profile) =>
            val userId = profile.getId
            Future.successful(Redirect(apConf.get[String]("routes.afterAuth")).withSession("userId" -> userId))
          case None =>
            logger.error(s"[CallbackRouter] No authenticated. Login information was not found.")
            Future.successful(Unauthorized("未認証です。ログイン情報が見つかりませんでした。"))
        }

        result

    } catch {
        case ex: Exception =>
          logger.error(s"[CallbackRouter] An exception occurred during the authentication process.: ${ex.getMessage}", ex)
          Future.successful(Unauthorized("認証に失敗しました。もう一度お試しください。"))
    }
  }
}