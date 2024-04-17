package lessons.basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  // side effects
  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF expression
  println(aConditionedValue)

//  var i = 0
//  while (i <= 10) {
//    println(i)
//    i += 1
//  }
// do not use while in scala!!!

  // Avoid while loops
  // Everything in Scala is an Expression!
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // Code blocks
  val aCodeBlock = {
    // internal scope
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  } // Value of the last expression

  // 1. difference between "hello world" - string vs println("hello world") - side effect

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  println(someOtherValue)
}
