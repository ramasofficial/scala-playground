package lessons.oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  println(person.greet("Daniel"))
  println(person.greet())

  val person2 = new Person()
  person2.greet()
}

class Person(name: String, val age: Int = 0) {
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // method overloading
  def greet(): Unit = println(s"Hi, I'm $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}


// class parameters are NOT FIELDS