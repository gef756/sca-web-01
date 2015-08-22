name := "sca-web-01"

version := "1.0"

scalaVersion := "2.11.7"

assemblyMergeStrategy in assembly <<= (assemblyMergeStrategy in assembly) { old => {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}}


libraryDependencies += "com.twitter" %% "finagle-http" % "6.27.0"