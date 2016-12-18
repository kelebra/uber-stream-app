import java.io.PrintWriter
import java.nio.file.Files

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

val prodIndexHtml =
  """
    |<html>
    |<head>
    |    <script type="text/javascript" src="./uber-stream-app-opt.js"></script>
    |</head>
    |<body>
    |<script type="text/javascript">
    |    com.github.kelebra.uber.stream.App().main();
    |</script>
    |</body>
    |</html>
  """.stripMargin

val githubPages = taskKey[Unit]("Copy index.html and js files")

githubPages := {
  // 1) Copy compiled prod js
  val js = (fullOptJS in Compile).value.data
  val jsTarget = new File(".", js.getName)
  Files.copy(js.toPath, jsTarget.toPath)

  // 2) Create prod index.html
  val index = new File(".", "index.html")
  if (index.exists()) index.delete()
  val writer = new PrintWriter(index)
  writer.write(prodIndexHtml)
  writer.close()
}