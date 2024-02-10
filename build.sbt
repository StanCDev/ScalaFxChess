val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "ScalaFxChess",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M10" % Test
  )


libraryDependencies ++= Seq(
  "org.scalafx"   %% "scalafx"   % "21.0.0-R32",
  "org.scalatest" %% "scalatest" % "3.2.17" % "test"
)

// Fork a new JVM for 'run' and 'test:run' to avoid JavaFX double initialization problems
fork := true

// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
Compile / run / mainClass := Some("ScalaFx.ChessFx")