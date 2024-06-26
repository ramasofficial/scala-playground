package lessons.oop

object CaseClasses extends App {
  /*
    equals, hashCode, toString
   */

  // case classes all parameters are fields
  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim) // casts to string
  println(jim.toString)

  // 3. equals and hashCode implemented OOTB - out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) //  true

  // 4. case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 5. case classes are serializable
  // Akka

  // 7. case classes have extractor patterns = case classes can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
