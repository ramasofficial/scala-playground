package lessons.oop

object AbstractDataTypes extends App {
  // abstract
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Dog"
    override def eat(): Unit = println("crunch crunch")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meet"
  }

  trait Coldblooded

  class Crocodile extends Animal with Carnivore with Coldblooded {
    override val creatureType: String = "croc"

    override def eat(): Unit = println("nom nom nom")

    override def eat(animal: Animal): Unit = println(s"I'm a crock and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behaviour, abstract class = type of "thing"
}
