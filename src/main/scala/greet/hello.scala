package greet

class hello(prefix: String, suffix: String) {
  def greeter(name: String): Unit =
    println(prefix + name + suffix)

  def sqrtplus1(x: Int): Double = {
    // Different from java import can be used anywhere
    import scala.math.sqrt
    sqrt(x) + 1.0
  }
}