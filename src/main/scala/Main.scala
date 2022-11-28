import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val carCsv = "./src/Resources/Car_data.csv" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application")
      .config("spark.master", "local")
      .getOrCreate()
    val CarDf = spark.read.option("header", "true").option("inferSchema", "true").csv(carCsv)
    println(CarDf.printSchema)
    println(CarDf.show)
    spark.stop()
  }
}
