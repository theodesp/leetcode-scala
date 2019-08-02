import scala.annotation.tailrec

/*
https://leetcode.com/discuss/interview-question/348632/Google-or-Phone-Screen-or-Max-Size-Subarray-Sum-Equals-k
Solution based on Sliding Window algorithm:
https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
object LongestSumArray extends App {
  def apply(arr: Seq[Int], budget: Int): Int = {
    @tailrec
    def loop(lookup: Map[Int, Int], max: Int, acc: Int, i: Int): Int = {
      if (i == arr.length)
        max
      else {
        val sum = arr(i) + acc
        var maxLen = max
        if (sum == budget)
          maxLen = i + 1
        if (!lookup.contains(sum - budget))
          loop(
            if (lookup.contains(sum)) lookup else lookup + (sum -> i),
            maxLen,
            sum,
            i + 1
          )
        else {
          val diff = i - lookup.get(sum - budget).head
          loop(
            if (lookup.contains(sum)) lookup else lookup + (sum -> i),
            math.max(diff, maxLen),
            sum,
            i + 1
          )
        }
      }
    }

    loop(Map(), 0, 0, 0)
  }

  println(apply(List(10, 5, 2, 7, 1, 9), 15))
  println(apply(List(1, 3, 4, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1), 10))
}
