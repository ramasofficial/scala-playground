package lessons.oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahhaha")
  }
  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahhaha")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  behind the scenes
  */

  println(funnyAnimal.getClass)
  println(funnyAnimal.eat)

  class Person(val name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is $name, how can I be of service?")
  }

  println(jim.sayHi)
}
