import scala.annotation.tailrec

/*
Suppose you have a line of n people in which the k-th person is described by a pair (h,t) , where h is the height of the k-th person and t is the number of people in front of k who have a height greater or equal than h . Write an algorithm to reconstruct the line.

For example, if the line is composed by the following people:

[(7, 0),(4, 4),(7,1), (5, 0), (6,1), (5, 2)]
The original line should be:

[(5,0), (7,0), (5,2), (6,1), (4,4),(7,1)]

See: https://leetcode.com/problems/queue-reconstruction-by-height/

Solution: We observe that the shortest person position matches the number of the people in front as
everyone is taller than him.
If we short by height descending and then by the number of people in from in ascending order then
we can find the relative order. Now we just need to iterate all the items and insert at the index specified
by the k-values;

(7,1), (7,0) -> (7,0), (7,1)
then after insert
(7,0), (7,1)
(7,1), (7,0), (6,1) -> -> (7,0), (7,1), (6,1)
then after insert
(7,0), (6,1), (7,1)
and so on

The trick is to understand the simple case and how to order them.
 */
object QueueReconstuctionHeight extends App {

  def apply(people: List[(Int, Int)]): List[(Int, Int)] = {
    @tailrec
    def loop(sorted: List[(Int, Int)],
             i: Int,
             out: List[(Int, Int)]): List[(Int, Int)] = {
      if (i == sorted.length)
        out
      else {
        val idx = sorted(i)._2
        loop(
          sorted,
          i + 1,
          out.take(idx) ++ List(sorted(i)) ++ out.drop(idx)
        )
      }
    }

    val sorted = people.sortBy(item => {
      (-item._1, item._2)
    })
    loop(sorted, 0, List())
  }
}
