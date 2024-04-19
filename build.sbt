import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.1"

lazy val root = (project in file("."))
  .settings(
    name := "learn-scala",
    libraryDependencies += "com.typesafe" % "config" % "1.4.3"
  )