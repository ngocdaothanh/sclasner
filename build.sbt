organization := "tv.cntt"

name         := "sclasner"

version      := "1.2"

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked"
)

// Publish ---------------------------------------------------------------------
// https://github.com/sbt/sbt.github.com/blob/gen-master/src/jekyll/using_sonatype.md

// https://github.com/harrah/xsbt/wiki/Cross-Build
//crossScalaVersions := Seq("2.9.1", "2.9.2")
scalaVersion := "2.9.2"

publishTo <<= (version) { version: String =>
  val nexus = "https://oss.sonatype.org/"
  if (version.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                                   Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://ngocdaothanh.github.com/xitrum/</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>https://github.com/ngocdaothanh/xitrum/blob/master/MIT-LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:ngocdaothanh/xitrum.git</url>
    <connection>scm:git:git@github.com:ngocdaothanh/xitrum.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ngocdaothanh</id>
      <name>Ngoc Dao</name>
      <url>http://cntt.tv</url>
    </developer>
  </developers>
)
