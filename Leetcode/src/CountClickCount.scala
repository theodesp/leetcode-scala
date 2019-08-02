import scala.annotation.tailrec

object CountClickCount extends App {
  def populate(out: Map[String, Int],
               domain: String,
               count: Int): Map[String, Int] = {
    @tailrec
    def loop(out: Map[String, Int],
             parts: Array[String],
             i: Int,
             currentDomain: String): Map[String, Int] = {
      if (i == parts.length)
        out
      else {
        var key: String = ""
        if (i == 0)
          key = parts(i)
        else
          key = s"${parts(i)}.$currentDomain"
        loop(
          out + (key -> (out.getOrElse(key, 0) + count)),
          parts,
          i + 1,
          key
        )
      }
    }
    loop(out, domain.split('.').reverse, 0, "")
  }

  def apply(clicks: Array[String]): Map[String, Int] = {
    @tailrec
    def loop(out: Map[String, Int], i: Int): Map[String, Int] = {
      if (i == clicks.length)
        out
      else {
        val (count, domain) = clicks(i).split(',') match {
          case Array(a: String, b: String) => (a.toInt, b)
        }
        loop(
          populate(out, domain, count),
          i + 1
        )
      }
    }

    loop(Map(), 0)
  }

  apply(
    Array(
      "900,google.com",
      "20,domain.com",
      "100,mail.yahoo.io",
    )).toArray.foreach(println)
}
