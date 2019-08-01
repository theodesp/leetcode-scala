import scala.annotation.tailrec

object Ch2 extends App {
  def selectionSort(nums: Seq[Int]): Seq[Int] = {
    @tailrec
    def recur(in: Seq[Int], out: Seq[Int]): Seq[Int] = {
      if (in.isEmpty)
        out
      else {
        val (element, index) = in.zipWithIndex.min
        recur(in.slice(0, index) ++ in.slice(index + 1, in.length),
              out :+ element)
      }
    }

    recur(nums, Seq.empty[Int])
  }
}
