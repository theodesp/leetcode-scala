import scala.annotation.tailrec
//Given a string, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//  Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//  Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//  Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

object LongestSubstringNonRepeating extends App {
  def apply(s: String): Int = lengthOfLongestSubstring(s)
  def lengthOfLongestSubstring(s: String): Int =
    s.length match {
      case l if l <= 1 => l
      case l if l > 1  => recur(s, Map(), 0, 0, 0)
    }
  @tailrec
  def recur(s: String,
            lookup: Map[Char, Int],
            i: Int,
            j: Int,
            ans: Int): Int = {
    if (j == s.length)
      ans
    else {
      val ch = s(j)
      if (lookup.contains(ch)) {
        val ii = math.max(lookup.get(ch).head, i)
        recur(
          s,
          lookup + (ch -> (j + 1)),
          ii,
          j + 1,
          math.max(ans, j - ii + 1)
        ) // proceed forward
      } else {
        recur(
          s,
          lookup + (ch -> (j + 1)),
          i,
          j + 1,
          math.max(ans, j - i + 1)
        ) // proceed forward
      }
    }
  }
}
