import ScalaxbKeys._

name := "gsn-wrappers"

organization := "es.upm.fi.oeg.morph.streams"

version := "1.0.1"

scalaVersion := "2.9.1"

crossPaths := false

libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core" % "0.9.5",
  "org.scalatest" % "scalatest_2.9.1" % "1.7.2" % "test",
  "org.scalacheck" % "scalacheck_2.9.1" % "1.9" % "test",
  "log4j" % "log4j" % "1.2.17",
  "org.jibx" % "jibx-bind" % "1.2.2",
  "commons-collections" % "commons-collections" % "3.2.1",  
  "ch.epfl.lsir" % "gsn" % "1.1.2"  
)

resolvers ++= Seq(
  DefaultMavenRepository,
  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
  "aldebaran-releases" at "http://aldebaran.dia.fi.upm.es/artifactory/sstreams-releases-local",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "sonatype-public" at "https://oss.sonatype.org/​content/repositories/public"  
)

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "es.emt.wsdl"

sourceGenerators in Compile <+= scalaxb in Compile

scalacOptions += "-deprecation"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)(Seq(_))

unmanagedSourceDirectories in Test <<= (scalaSource in Test)(Seq(_))

parallelExecution in Test := false

publishTo := Some("Artifactory Realm" at "http://aldebaran.dia.fi.upm.es/artifactory/sstreams-releases-local")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishMavenStyle := true

publishArtifact in (Compile, packageSrc) := false
