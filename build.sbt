name := "scala-activerecord-profile"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "com.github.aselab" %% "scala-activerecord" % "0.2.2",
  "com.h2database" % "h2" % "1.3.172",
  "org.slf4j" % "slf4j-nop" % "1.7.5"
)

scalacOptions ++= Seq("-deprecation", "-unchecked")

fork in run := true

javaOptions in run ++= Seq("-agentlib:hprof=cpu=times,depth=30")
