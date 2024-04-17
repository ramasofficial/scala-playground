package lessons

object Variables extends App {
  val x: Int = 42;
  println(x)
  // Vals are immutable like javascript const

  val aString: String = "hello"
  println(aString)

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aShort: Short = 4613
  val aLong: Long = 5565565655665L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  var aVariable: Int = 4
  aVariable = 5
  println(aVariable)
}
