name := "test-app"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "org.scalacheck"  %% "scalacheck"  % "1.14.0" % Test,
  "org.scalatest"   %% "scalatest"   % "3.0.5"  % Test,
)
