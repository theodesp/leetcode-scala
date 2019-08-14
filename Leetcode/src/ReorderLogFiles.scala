import scala.util.Try

/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.

 */
object ReorderLogFiles extends App {
  def reorderLogFiles(logs: Array[String]): Array[String] = {
    if (logs.length < 2)
      logs
    else {
      logs.sortInPlaceWith(logSort).toArray
    }
  }

  def logSort(log1: String, log2: String): Boolean = {
    val parts1 = log1.split(" ", 2).toList
    val parts2 = log2.split(" ", 2).toList
    val isDigit1 = Character.isDigit(parts1(1)(0))
    val isDigit2 = Character.isDigit(parts2(1)(0))
    if (!isDigit1 && !isDigit2) {
      val cmp = parts1(1).compareTo(parts2(1))
      if (cmp > 0)
        return false
      else if (cmp < 0)
        return true
      else {
        val cmp = parts1(0).compareTo(parts2(0))
        if (cmp > 0)
          return false
        else
          return true
      }
    }
    if (isDigit1) {
      return false
    } else {
      return true
    }
  }

  reorderLogFiles(
    Array("a1 9 2 3 1",
          "g1 act car",
          "zo4 4 7",
          "ab1 off key dog",
          "a8 act zoo",
          "a2 act car")).foreach(println)

}
