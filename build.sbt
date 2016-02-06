import com.lihaoyi.workbench.Plugin._
import java.nio.charset.Charset

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

val buildMainPath = SettingKey[File]("build-main-path", "The absolute path where to write engine js.")

val buildDepsPath = SettingKey[File]("build-deps-path", "The absolute path where to write engine's js deps")

val buildMain = TaskKey[File]("build-main", "Generate engine main js file.")
val buildDeps = TaskKey[File]("build-deps", "Generate engine deps js file .")

buildMainPath := {
  baseDirectory.value / "build" / "sheepable-engine.js"
}

buildDepsPath := {
  baseDirectory.value / "build" / "sheepable-engine-deps.js"
}

buildMain := {
  val jsCode: String = IO.read((fastOptJS in Compile).value.data, Charset.forName("UTF-8"))

  val dest = buildMainPath.value
  IO.write(dest, "" + jsCode, Charset.forName("UTF-8"))
  dest
}

buildDeps := {
  val jsDeps: String = IO.read((packageJSDependencies in Compile).value, Charset.forName("UTF-8"))

  val dest = buildDepsPath.value
  IO.write(dest, "" + jsDeps, Charset.forName("UTF-8"))
  dest
}
