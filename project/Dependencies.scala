import sbt._

object Dependencies {
  val akkaVersion = "2.5.3"
  val akkaHttpVersion = "10.0.9"
  val hadoopVersion = "2.8.0"
  val log4j2Version = "2.8.2"
  val slickVersion = "3.2.0"
  val postgresqlVersion = "42.1.3"

  lazy val hdfsDependencies = Seq(
    "org.apache.hadoop" % "hadoop-client" % hadoopVersion,
    "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion
  )

  lazy val akkaDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
  )

  lazy val akkaHttpDependencies = Seq(
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    //"com.typesafe.akka" %% "akka-http-jackson" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-xml" % akkaHttpVersion,
    "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.9.2" exclude("javax.ws.rs", "jsr311-api"),
    "ch.megard" %% "akka-http-cors" % "0.2.1"
  )


  lazy val logDependencies = Seq(
    "org.apache.logging.log4j" % "log4j-api" % log4j2Version,
    "org.apache.logging.log4j" % "log4j-core" % log4j2Version,
    "org.apache.logging.log4j" % "log4j-slf4j-impl" % log4j2Version,
    "org.apache.logging.log4j" %% "log4j-api-scala" % log4j2Version
  )

  lazy val commonDependencies = akkaDependencies
    .union(akkaHttpDependencies)
    .union(logDependencies)

  lazy val codegenDependencies = commonDependencies
    .union(Seq(
      "org.postgresql" % "postgresql" % postgresqlVersion,
      "com.github.tminglei" %% "slick-pg" % "0.15.1",
      "com.typesafe.slick" %% "slick-codegen" % slickVersion
    ))

  lazy val hydroServingManagerDependencies = commonDependencies
    .union(akkaHttpDependencies)
    .union(Seq(
      "com.github.seratch" %% "awscala" % "0.6.+",
      "org.postgresql" % "postgresql" % postgresqlVersion,
      "com.typesafe.slick" %% "slick" % slickVersion,
      "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
      "com.zaxxer" % "HikariCP" % "2.6.3",
      "com.github.tminglei" %% "slick-pg" % "0.15.1",
      "org.flywaydb" % "flyway-core" % "4.2.0",
      "com.spotify" % "docker-client" % "8.8.0" exclude("ch.qos.logback", "logback-classic")
    )
    )
}