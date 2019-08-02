import scala.annotation.tailrec

/*
Given a matrix A, write a matrix M for which every element [i,j] is the sum of all elements of A left and above A[i,j]

Considering the following matrix A:

[
  [3, 7, 1],
  [2, 4, 0],
  [9, 4, 2]
]
Compute M:

[
  [3,  10, 11],
  [5,  16, 17],
  [14, 29, 32]
]

Solution:
Do row and column summations.
Make sure you cater for edge cases for example when row-1 < 0 or col-1 < 0
https://leetcode.com/discuss/interview-question/125148/Google-Matrix-sum-all-elements

See: https://www.geeksforgeeks.org/submatrix-sum-queries/
 */

object MatrixSumAll extends App {
  def apply(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    @tailrec
    def loop(out: Array[Array[Int]],
             i: Int,
             j: Int,
             sum: Int): Array[Array[Int]] = {
      if (i == matrix.length)
        out
      else {
        if (j == matrix(i).length)
          loop(out, i + 1, 0, 0)
        else {
          val newSum = sum + out(i)(j)
          if (i == 0)
            out(i)(j) = newSum
          else
            out(i)(j) = newSum + out(i - 1)(j)
          loop(out, i, j + 1, newSum)
        }
      }
    }
    loop(matrix, 0, 0, 0)
  }

  apply(Array(Array(3, 7, 1), Array(2, 4, 0), Array(9, 4, 2))).foreach(i =>
    i.foreach(println))
}
