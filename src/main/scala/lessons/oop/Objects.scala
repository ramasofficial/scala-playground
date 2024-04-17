package lessons.oop

object Objects {
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person {
    // "static"/"class" - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    // Factory method
    def from(mother: Person, father: Person): Person = new Person("Bobbie")

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS - class and object with the same name

  // you must to extend App or define main method in order to run application
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val mary2 = Person
    val john2 = Person
    println(mary2 == john2)

    val bobbie = Person(mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
    // Unit is void method
  }
}
