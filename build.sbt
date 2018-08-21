ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.12.6"
ThisBuild / version := "0.1"

val rpRequiredAlpinePackages = settingKey[Seq[String]]("")

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, SbtReactiveAppPlugin)
  .settings(
    name := "play-hello-certification",
    libraryDependencies += guice,
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
    endpoints := HttpEndpoint(
      name = "http",
      ingress = new HttpIngress(
        ingressPorts = Vector(80, 443),
        hosts = Vector.empty,
        paths = Vector("/")
      )
    ) :: Nil,
    dockerBaseImage := "jboss/base-jdk:8",
    rpRequiredAlpinePackages := Nil
  )

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
