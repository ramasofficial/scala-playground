package lessons.oop

import playground.{Cinderella => Princess, PrinceCharming}
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {
  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess // playground.Cinderella = fully qualified name
  // aliasing

  // packages are in hierarchy
  // matching folder structure.

  // package object - visible thorough all package
  sayHello()

  // imports
  val prince = new PrinceCharming

  // 1. use FQ names
  val d = new Date
  val sqlDate = SqlDate(2018, 5, 4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
  // Mirror the file structure
}
