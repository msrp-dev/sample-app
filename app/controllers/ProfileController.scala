package controllers

import javax.inject._
import play.api.mvc._
import play.api.Logging

@Singleton
class ProfileController @Inject() (
  val controllerComponents: ControllerComponents
) extends BaseController with Logging {

  // セッションからユーザIDを取得して画面に表示
  def profile = Action { request: Request[AnyContent] =>
    val result: Result = request.session.get("userId") match {
      case Some(userId) =>
        Ok(s"こんにちは、ユーザー $userId さん！")
      case None =>
        Unauthorized("ログイン情報が見つかりませんでした。")
    }
    result
  }
}