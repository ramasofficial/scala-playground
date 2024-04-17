package lessons.oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(string: String): Person = new Person(s"$name ($string)", this.favouriteMovie)

    def unary_! : String = s"$name, what the heck?"

    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"

    def apply(n: Int): String = s"$name wathed $favouriteMovie $n times"

    def learns(thing: String): String = s"$name is learning $thing"

    def learnsScala: String = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)

  println(1 + 2)
  println(1.+(2))

  // All operators are methods
  // Akka actors have ! ?

  // prefix notation
  val x= -1
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())
  println((+mary).age)

  println(mary.learns("Scala"))
  println(mary learnsScala)

  println(mary(4))
}