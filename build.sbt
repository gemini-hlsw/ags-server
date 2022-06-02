import com.typesafe.sbt.packager.docker.Cmd

// Plugins
enablePlugins(JavaAppPackaging)

// Project Settings
name                 := "ags-server"
scalaVersion         := "2.11.12"
scalacOptions        += "-Yrangepos"
libraryDependencies ++= Seq(
  "org.eclipse.jetty" %  "jetty-server"  % "9.4.15.v20190215",
  "org.eclipse.jetty" %  "jetty-servlet" % "9.4.15.v20190215"
)

