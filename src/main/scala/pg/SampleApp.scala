package pg

import scala.io._

object MyApp extends App {

  println("Hello! What is your name?")
  val name = StdIn.readLine()
  println(s"Hello, ${name}, welcome to ZIO!")

}