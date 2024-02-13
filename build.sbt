useJGit

// Plugins
enablePlugins(JavaAppPackaging)
enablePlugins(GitVersioning)
enablePlugins(BuildInfoPlugin)

git.useGitDescribe := true

// Project Settings
name                 := "ags-server"
scalaVersion         := "2.11.12"
scalacOptions        += "-Yrangepos"
libraryDependencies ++= Seq(
  "org.eclipse.jetty" %  "jetty-server"  % "9.4.54.v20240208",
  "org.eclipse.jetty" %  "jetty-servlet" % "9.4.54.v20240208"
)

buildInfoKeys := Seq[BuildInfoKey](name, version, git.gitDescribedVersion, git.baseVersion, buildInfoBuildNumber)
buildInfoPackage := "ags"
