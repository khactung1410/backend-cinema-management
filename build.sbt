name := "cinema_management"
 
version := "1.0" 
      
lazy val `cinema_management` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

libraryDependencies ++= Seq(evolutions, jdbc)

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "3.3.5",
  "com.h2database"  %  "h2"                % "1.4.199",
  "ch.qos.logback"  %  "logback-classic"   % "1.2.3",
  "org.scalikejdbc"       %% "scalikejdbc-config"           % "3.3.5",
  "org.scalikejdbc"       %% "scalikejdbc-play-initializer" % "2.7.1-scalikejdbc-3.3",
  "ch.qos.logback"        %  "logback-classic"              % "1.1.+",
  "mysql"                 % "mysql-connector-java"          % "8.0.15",
  "org.specs2"            %% "specs2-core"                  % "4.7.1"   % Test,
  "org.mockito"           % "mockito-core"                  % "3.0.0"   % Test,
  "org.scalikejdbc"       %% "scalikejdbc-test"             % "3.3.5"   % Test,
  "org.flywaydb"          %% "flyway-play"                  % "5.3.3",
  "org.skinny-framework"  %% "skinny-orm"                   % "3.0.3",
  "org.mockito" % "mockito-core" % "3.0.0" % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test,
  "org.mindrot" % "jbcrypt" % "0.4"
)
// will be executed when invoking sbt console
initialCommands := """
import scalikejdbc._
import skinny.orm._, feature._
import org.joda.time._
skinny.DBSettings.initialize()
implicit val session = AutoSession
"""