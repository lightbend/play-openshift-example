import com.typesafe.sbt.packager.docker._

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.12.6"
ThisBuild / version := "0.10"
ThisBuild / description := "Hello world Play application"

val rpRequiredAlpinePackages = settingKey[Seq[String]]("")

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, SbtReactiveAppPlugin)
  .settings(
    name := "play-openshift-example",
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
    dockerBaseImage := "registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:1.4-6.1533127995",
    rpRequiredAlpinePackages := Nil,
    dockerLabels := Map(
      "name"        -> "lightbend/play-openshift-example",
      "io.k8s.description" -> description.value,
      "description"        -> description.value,
      "vendor"      -> "Lightbend, Inc",
      "version"     -> version.value,
      "summary"     -> description.value,
      "usage"       -> "This image is a demonstration of Play on OpenShift",
      "maintainer"  -> "info@lightbend.com"
    ),
    Docker / mappings := {
      (Docker / mappings).value :+
      ((baseDirectory.value / "licenses" / "LICENSE") -> "licenses/LICENSE")
    },
    Docker / dockerCommands += Cmd("COPY", "--chown=daemon:daemon", "licenses", "/licenses")
  )

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
