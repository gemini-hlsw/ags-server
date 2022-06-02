import com.typesafe.sbt.packager.docker.Cmd

// Plugins
enablePlugins(JavaAppPackaging)

// Project Settings
name                 := "ags-server"
scalaVersion         := "2.11.11"
scalacOptions        += "-Yrangepos"
libraryDependencies ++= Seq(
  "org.eclipse.jetty" %  "jetty-server"  % "9.4.46.v20220331",
  "org.eclipse.jetty" %  "jetty-servlet" % "9.4.46.v20220331"
)

