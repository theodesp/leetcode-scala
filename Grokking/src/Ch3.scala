import scala.annotation.tailrec

object Ch3 extends App {
  def factorial(n: Int): Int =
    n match {
      case 0 | 1 => n
      case m     => m * factorial(m - 1)
    }

  def factorial2(n: Int): Int = {
    @tailrec
    def recur(n: Int, acc: Int): Int =
      n match {
        case 0 => 0
        case 1 => acc
        case m => recur(m - 1, acc * m)
      }
    recur(n, 0)
  }
}
