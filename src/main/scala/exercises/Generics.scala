package exercises

import exercises.Generics.Ship

object Generics extends App {

  class Ship[T](value: T) {
    def getValue: T = value
  }

  val ship = Ship[String]("Test ship")
  println(ship.getValue)

  val intShip = Ship[Int](4)
  println(intShip.getValue)

  def printValue[T](value: T): Unit = println(value)

  printValue(6)
  printValue("Test")

  class Box[T <: Number](value: T) {
    // T must be a subtype of Number
  }

  class Container[T >: String](value: T) {
    // T must be a supertype of String
  }

  class ShipContainer[+T](value: T) {
    // Container is covariant in T
  }

  val smallBox = new Box(6)
  val container = new Container("Test")
  val shipContainer = new ShipContainer[Int](10)
}
