enablePlugins(ScalaJSPlugin)

name := "uber-stream-app"

scalaVersion := "2.11.8"

scalaBinaryVersion := "2.11"

sbtVersion := "0.13.7"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "com.lihaoyi" %%% "scalatags" % "0.4.5",
  "com.lihaoyi" %%% "upickle" % "0.4.1",
  "com.lihaoyi" %%% "utest" % "0.4.0" % "test"
)

testFrameworks += new TestFramework("utest.runner.Framework")

scalaJSStage := FastOptStage

jsDependencies += RuntimeDOM