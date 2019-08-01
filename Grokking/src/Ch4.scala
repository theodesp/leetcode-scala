import scala.annotation.tailrec

object Ch4 extends App {
  def sum(nums: Seq[Int]) = {
    @tailrec
    def sumAccumulator(nums: Seq[Int], acc: Int): Int = {
      nums match {
        case Nil       => acc
        case x :: tail => sumAccumulator(tail, acc + x)
      }
    }
    sumAccumulator(nums, 0)
  }

  def max(nums: Seq[Int]) = {
    @tailrec
    def maxRecur(nums: Seq[Int], max: Int): Int = {
      nums match {
        case Nil       => max
        case x :: tail => maxRecur(tail, if (max < x) x else max)
      }
    }
    maxRecur(nums, -1)
  }

  def quickSort(nums: Seq[Int]): Seq[Int] = {
    if (nums.length < 2)
      nums
    else {
      val m: Int = (nums.length - 1) >> 1 // pivot index
      val left = nums.filter(n => n < nums(m))
      val right = nums.filter(n => n > nums(m))

      Seq.concat(
        quickSort(left),
        Seq(nums(m)),
        quickSort(right),
      )
    }
  }

  println(quickSort(List()))
  println(quickSort(List(1)))
  println(quickSort(List(1, 2)))
  println(quickSort(List(2, 1)))
  println(quickSort(List(10, 5, 1, 3)))
}
