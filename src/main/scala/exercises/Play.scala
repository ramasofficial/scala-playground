package exercises

import java.lang.Number

object Play extends App {
  class Person[A >: String, B <: Number](name: A, age: B) {
    def print(): Unit = println(s"$name is $age years old.")
  }

  val person = new Person[String, Integer]("John", 18)
  person.print()
}
