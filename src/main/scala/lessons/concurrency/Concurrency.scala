package lessons.concurrency

import java.io.{File, PrintWriter}
import java.util.concurrent.{Executors, ThreadFactory}
import java.util.concurrent.atomic.AtomicInteger
import scala.concurrent.{Await, ExecutionContextExecutor, Future}
import scala.concurrent.duration.*
import scala.concurrent.ExecutionContext.Implicits.global

object Concurrency {
  def print(x: Int): Unit = println(s"Number is $x")

  class TrackingThreadFactory extends ThreadFactory {
    val threadCount: AtomicInteger = new AtomicInteger(0)

    override def newThread(r: Runnable): Thread = {
      val thread = Executors.defaultThreadFactory().newThread(r)
      threadCount.incrementAndGet()
      thread
    }

    def getActiveThreadCount: Int = threadCount.get()
  }

  private def writeToLogFile(x: Int): Future[Unit] = Future {
    val file = new File("data/output.txt")
    val writer = new PrintWriter(new java.io.FileWriter(file, true))
    print(x)
    writer.println(s"Number is $x")
    writer.close()
  }

  def cleanFile(): Unit = {
    val file = new File("data/output.txt")
    val writer = new PrintWriter(file)
    writer.close()
    println("File cleaned successfully.")
  }

  def main(args: Array[String]): Unit = {
    cleanFile()
    val startTime = System.currentTimeMillis()

    val threadFactory = new TrackingThreadFactory()
    val executor = Executors.newFixedThreadPool(10, threadFactory) // Creating a fixed thread pool with 10 threads
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.fromExecutor(executor)

    val futures = for (num <- 1 to 100000) yield writeToLogFile(num)
    val allDone = Future.sequence(futures)
    Await.result(allDone, 40.seconds)

    println("All done.")
    executor.shutdown()

    val endTime = System.currentTimeMillis()
    val executionTimeInMillis = endTime - startTime
    val executionTimeInSeconds = executionTimeInMillis.toDouble / 1000.0

    println(s"Script execution time: $executionTimeInSeconds seconds")
    println(s"Active threads at the end: ${threadFactory.getActiveThreadCount}")
  }
}
