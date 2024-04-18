package lessons.oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^ will crash with a NPE

  // throwing and catching exceptions

  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 32
    case e: NullPointerException => println("caught a Runtime exception")
  } finally  {
    // code that will get executed NO MATTER WHAT
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException(msg: String) extends Exception(msg)

  val exception = new MyException("ahahaha")

  // throw exception

  // Exercises
  //throw new OutOfMemoryError("Out of memory")

  //throw new StackOverflowError()

  // OOM
  // val array = Array.ofDim(Int.MaxValue)
  // SO
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  val calculator = PocketCalculator
  println(calculator.add(5, 5))
  println(calculator.subtract(10, 5))
  println(calculator.multiply(2, 2))
  println(calculator.divide(4, 2))

  //println(calculator.add(Int.MinValue, -5))
  println(calculator.divide(10, 0))
}
