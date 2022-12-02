import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    //    val carCsv = "./src/Resources/synapse.csv" // Should be some file on your system
    val table1 = "./src/Resources/table1.csv"
    val table2 = "./src/Resources/table2.csv"
    val spark = SparkSession.builder.appName("Simple Application")
      .master("local[1]")
      .appName("SparkByExamples")
      .getOrCreate()
    val Table1Df = spark.read.option("header", "true").option("inferSchema", "true").csv(table1)
    val Table2Df = spark.read.option("header", "true").option("inferSchema", "true").csv(table2)
    Table1Df.createOrReplaceTempView("table1Df")
    Table2Df.createOrReplaceTempView("table2Df")
    spark.sql("select table1Df.first_name, table2Df.first_name from table1Df, table2Df where table1Df.city = table2Df.city").show
    //    println(Table1Df.printSchema)
    //    println(Table1Df.show)
    spark.stop()
  }
}
