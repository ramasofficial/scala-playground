package variables

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  // Use accumulators
  // When you need loops use _TAIL_ recursion

  @tailrec
  def concatString(s: String, t: Int, accumulator: String): String = {
    if (t <= 0) accumulator
    else concatString(s, t - 1, s + accumulator)
  }


  println(concatString("c", 10, ""))
  // b -> 3
  // bb -> 2
  // bbb -> 1

}