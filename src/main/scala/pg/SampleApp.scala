package pg

import zio._
import zio.console._

object MyApp extends App {

  def run(args: List[String]) =
    myAppLogic.fold(_ => 1, _ => 0)

  val myAppLogic =
    for {
      _      <- putStrLn("Hello! What is your name?")
      name   <- getStrLn
      _      <- putStrLn(s"What is your age?")
      ageStr <- getStrLn
      age    <- ZIO{ageStr.toInt}.onError { cause =>
        putStrLn(s"Unable to parse $ageStr as Integer") *> ZIO.dieMessage("")
      }
      _      <- putStrLn(s"Hello, ${name}, welcome to ZIO! $age")
    } yield ()
}