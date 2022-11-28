import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val logFile = "./README.md" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application").config("spark.master", "local").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()

    //    println("Hello world!")
    //    lazy val geek = {
    //      println("Initialization for the first time")
    //      12
    //    } // Part 1
    //    println(geek)
    //
    //    // Part 2
    //    val addOne = (x: Int) => x + 1
    //    println(geek)
    //    println({
    //      val x = 1 + 1
    //      x + 1
    //    }) // 3
    //    println(addThenMultiply(2, 3)(2))
    //    println("Hello, " + name + "!")
    //    // Importing from self package main
    //    val greeter = new Greeter("Hello, ", "!")
    //    // Importing from other package i.e. greet
    //    val greeter2 = new hello("Hello, ", "!")
    //    greeter.greet("Scala developer")
    //    greeter2.greeter("Scala developer from other package")
    //    println(greeter2.sqrtplus1(4))
  }

  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = {
    (x + y) * multiplier
  }

  def name: String = System.getProperty("user.name")
}
