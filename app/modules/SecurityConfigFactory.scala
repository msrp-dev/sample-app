package modules

import javax.inject._
import play.cache.SyncCacheApi
import org.pac4j.core.config.Config
import org.pac4j.core.client.Clients
import org.pac4j.saml.client.SAML2Client
import org.pac4j.saml.config.SAML2Configuration
import org.pac4j.play.CallbackController
import org.pac4j.play.store.PlayCacheSessionStore
import org.pac4j.core.context.session.SessionStore
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.FileSystemResource
import play.libs.concurrent.HttpExecutionContext
import org.pac4j.play.http.PlayHttpActionAdapter
import play.api.Configuration


@Singleton
class SecurityConfigFactory @Inject()(cacheApi: SyncCacheApi, httpExecutionContext: HttpExecutionContext, apConf: Configuration) {

    // Keycloak用のSAML設定
    val samlConfig = new SAML2Configuration()
    samlConfig.setServiceProviderEntityId(apConf.get[String]("saml.sp.entityId"))                           // SPのエンティティID
    samlConfig.setNameIdPolicyFormat("urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified")
    samlConfig.setNameIdPolicyAllowCreate(true)
    samlConfig.setAuthnRequestSigned(false)                                                                 // SPからのSAML認証要求は署名無し
    samlConfig.setWantsAssertionsSigned(true)                                                               // IdPからのSAMLアサーションは署名必須
    samlConfig.setKeystoreResource(new FileSystemResource(apConf.get[String]("saml.sp.keystoreResource")))  // SPの署名用キーストア（署名無しでもキーストア自体は用意しておく必要あり）
    samlConfig.setKeystorePassword(apConf.get[String]("saml.sp.keystorePassword"))                          // キーストアのパスワード（同上）
    samlConfig.setPrivateKeyPassword(apConf.get[String]("saml.sp.privatekeyPassword"))                      // キーのパスワード（同上）
    val idpMetadata = new ClassPathResource(apConf.get[String]("saml.idp.metadata"))
    samlConfig.setIdentityProviderMetadataResource(idpMetadata)                                             // Keycloakのメタデータ
    samlConfig.setAuthnRequestBindingType("urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Redirect")             // SAML認証要求はHTTP-Redirectで送信
    samlConfig.setMaximumAuthenticationLifetime(3600)                                                       // 認証有効時間（秒）

    // SAML2Clientの初期化
    val saml2Client = new SAML2Client(samlConfig)
    saml2Client.setName("SAML2Client")
    saml2Client.setCallbackUrl(apConf.get[String]("saml.callbackUrl"))

    // クライアントの登録
    val clients = new Clients(saml2Client)
    
    // pac4jのConfig構築
    val config = new Config(clients)

    // Play用セッションストア（キャッシュベース）
    val sessionStore: SessionStore = new PlayCacheSessionStore(cacheApi)
    config.setSessionStore(sessionStore)

    // Play用のHttpActionAdapterを明示的にセット
    config.setHttpActionAdapter(new PlayHttpActionAdapter())

    // CallbackControllerの設定
    val callbackController = new CallbackController()
    callbackController.setConfig(config)
    callbackController.setDefaultUrl(apConf.get[String]("routes.afterAuth"))

    def getConfig: Config = config
    def getCallbackController: CallbackController = callbackController
}