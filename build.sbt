import com.lihaoyi.workbench.Plugin._

// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

workbenchSettings

name := "Sheepable Engine"

scalaVersion := "2.11.7"

version := "0.1-SNAPSHOT"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0"
)
jsDependencies ++=  Seq(
)

bootSnippet := "ScalaJSExample().main();"

// disableOptimizer := true
scalaJSOptimizerOptions ~= { _.withDisableOptimizer(true) }

spliceBrowsers <<= spliceBrowsers.triggeredBy(fastOptJS in Compile)

refreshBrowsers <<= refreshBrowsers.triggeredBy(fastOptJS in Compile)

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

skip in packageJSDependencies := false
