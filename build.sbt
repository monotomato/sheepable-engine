enablePlugins(ScalaJSPlugin)

name := "Sheepable Engine"

scalaVersion := "2.11.7"

version := "0.1-SNAPSHOT"

resolvers += { Opts.resolver.sonatypeSnapshots }

// libraryDependencies += "org.json4s" % "json4s-native_2.11" % "3.3.0"
// libraryDependencies += "org.json4s" % "json4s-jackson_2.11" % "3.3.0"
// libraryDependencies += "org.json4s" % "json4s-ast_2.11" % "4.0.0-M1"
libraryDependencies += "com.lihaoyi" %%% "upickle" % "0.3.8"
