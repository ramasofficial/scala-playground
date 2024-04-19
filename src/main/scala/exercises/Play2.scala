package exercises

import exercises.Play2.Configuration

import java.nio.file.{Files, Paths}

object Play2 {
  class Configuration(val configFile: String)

  def main(args: Array[String]): Unit = {
    if (args.isEmpty || args.length % 2 != 0) {
      println("Usage of this command: [--config-file config-file]")
      return
    }

    val parsedConfiguration = parseConfiguration(args)

    val configuration: Option[Configuration] = parsedConfiguration match
      case Some(config: Configuration) => Some(config)
      case None => None

    if (configuration.isEmpty) {
      printNotFound("")
      return
    }

    val fileExists = Files.exists(Paths.get(configuration.get.configFile))

    if(!fileExists) {
      printNotFound(configuration.get.configFile)
      return
    }

    println(s"Configuration found ${configuration}.")
    println("Config is passed correctly, starting the application.")
  }

  private def parseConfiguration(args: Array[String]): Option[Configuration] = {
    val argMap = Map.newBuilder[String, String]

    args.sliding(2, 2).collectFirst {
      case Array("--config-file", configFile: String) => Configuration(configFile)
    }
  }

  private def printNotFound(path: String): Unit = {
    if (path != "") println(s"Configuration $path not found, closing the application.")
    else println(s"Configuration not found, closing the application.")
  }
}
