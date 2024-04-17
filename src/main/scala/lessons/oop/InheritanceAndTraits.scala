package lessons.oop

object InheritanceAndTraits extends App {
  // single class inheritance
//  class Animal {
//    val creatureType: String = "Animal"
//    def eat: Unit = println("nomnom")
//  }

  sealed class Animal {
    val creatureType: String = "Animal"
    def eat: Unit = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "Dog"
    override def eat: Unit = {
      // call to superclass method eat
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("Wild")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // prevent to extend class use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files
}
