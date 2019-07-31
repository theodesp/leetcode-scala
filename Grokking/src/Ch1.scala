import scala.annotation.tailrec

object Ch1 extends App {
  def binarySearch(list: List[Int], target: Int): Int = {
    var (lo, hi) = (0, list.length - 1)
    while (lo <= hi) {
      val m: Int = ((lo.toLong + hi.toLong) >> 1).toInt
      if (list(m) == target)
        return m
      else {
        if (list(m) > target)
          hi = m - 1
        else
          lo = m + 1
      }
    }
    -1
  }

  def binarySearchRec(list: List[Int], target: Int): Int = {
    @tailrec
    def recur(lo: Int, hi: Int): Int = {
      if (lo >= hi)
        -1
      else {
        val m: Int = ((lo.toLong + hi.toLong) >> 1).toInt
        list(m) match {
          case v if v == target => m
          case v if v > target  => recur(lo, m)
          case v if v <= target => recur(m + 1, hi)
        }
      }
    }
    recur(0, list.length - 1)
  }
}
