package lessons.oop

object OOPExercise extends App {
  val writer: Writer = new Writer("John", "Depo", 18)
//  println(writer.getFullName)

  val novel = new Novel("Test Novel", 2020, writer)

  println(novel.isWrittenBy(writer))
  println(novel.authorAge)
  println(novel.copy(2024).isWrittenBy(writer))

  val counter: Counter = new Counter

  counter.increment.increment.increment.print()
  counter.increment.increment.increment.decrement.print()

  counter.increment(3).print()

  counter.increment(10).decrement(3).print()
}

class Writer(firstName: String, surname: String, val year: Int) {
  def getFullName: String = s"$firstName $surname $year"
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge: Int = author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val n: Int = 0) {
  def increment: Counter = new Counter(n + 1)

  def decrement: Counter = new Counter(n - 1)

  def increment(n: Int): Counter =
    if (n <= 0) this
    else increment.increment(n - 1)

  def decrement(n: Int): Counter =
    if (n <= 0) this
    else decrement.decrement(n - 1)

  def print(): Unit = println(n)
}