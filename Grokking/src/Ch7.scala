import scala.annotation.tailrec

object Ch7 extends App {
  def longestCommonSubstring(a: String, b: String): String = {
    @tailrec
    def loop(lookup: Array[Array[Int]],
             lcs: Int,
             lcsIndex: Int,
             i: Int,
             j: Int): String = {
      if (i == a.length) {
        a.slice(lcsIndex - lcs, lcsIndex)
      } else {
        if (j == b.length)
          loop(lookup, lcs, lcsIndex, i + 1, 1)
        else {
          if (a(i - 1) == b(j - 1)) {
            lookup(i)(j) = lookup(i - 1)(j - 1) + 1
            loop(lookup,
                 math.max(lookup(i)(j), lcs),
                 if (lookup(i)(j) > lcs) i else lcsIndex,
                 i,
                 j + 1)
          } else {
            lookup(i)(j) = 0
            loop(lookup, lcs, lcsIndex, i, j + 1)
          }
        }
      }
    }

    loop(Array.ofDim[Int](a.length, b.length), 0, 0, 1, 1)
  }

  println(
    longestCommonSubstring("OldSite:GeeksforGeeks.org",
                           "NewSite:GeeksQuiz.com"))
}
