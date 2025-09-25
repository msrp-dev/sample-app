name := """playSample"""
organization := "organization"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.16"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.11"

// play-pac4j、pac4j-samlへの依存性を追加
resolvers += "Shibboleth Releases" at "https://build.shibboleth.net/maven/releases/"
resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases/"
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.8.20",
  "com.typesafe.play" %% "play-guice" % "2.8.20",
  "com.typesafe.play" %% "play-cache" % "2.8.20",
  "com.typesafe.play" %% "play-ehcache" % "2.8.20",
  "com.typesafe.play" %% "twirl-api" % "1.5.1", // Play 2.8 用 Twirl
  ("org.pac4j" %% "play-pac4j" % "11.0.0-PLAY2.8")
    .exclude("org.playframework.twirl", "twirl-api_2.13") // Twirl 2.x を除外
    .exclude("com.typesafe.play", "twirl-api_2.13"),      // 念のため旧groupIdも除外
  "org.pac4j" % "pac4j-saml" % "5.6.0"
)

// Playのバージョンを固定化
dependencyOverrides += "com.typesafe.play" %% "play" % "2.8.20"

// scala-xmlのバージョンを固定化（Scala 2.13.16 用）
dependencyOverrides += "org.scala-lang.modules" %% "scala-xml" % "2.0.1"

// Guiceのバージョンを固定化
dependencyOverrides += "com.google.inject" % "guice" % "5.0.1"
dependencyOverrides += "com.google.inject.extensions" % "guice-assistedinject" % "5.0.1"

// pac4j-core のバージョンを明示的に固定（pac4j 5.x 対応）
dependencyOverrides += "org.pac4j" % "pac4j-core" % "5.6.0"

// Guavaのバージョンを固定化
dependencyOverrides += "com.google.guava" % "guava" % "31.1-jre"

// SLF4Jのバージョンを固定化
dependencyOverrides += "org.slf4j" % "slf4j-api" % "1.7.36"
dependencyOverrides += "org.slf4j" % "jcl-over-slf4j" % "1.7.36"
dependencyOverrides += "org.slf4j" % "jul-to-slf4j" % "1.7.36"

// jacksonのバージョンを固定化
val jacksonVersion = "2.11.4"
dependencyOverrides ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % jacksonVersion,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % jacksonVersion,
  "com.fasterxml.jackson.module" % "jackson-module-scala" % jacksonVersion
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "organization.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "organization.binders._"
