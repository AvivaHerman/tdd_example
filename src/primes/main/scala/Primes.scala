package scala


class Primes {

}

object Primes {
  def For(i: Int): Seq[Int] = {
    var res: Seq[Int] = Seq()
    var j = i

    for(k <- 2 to (Math.sqrt(i.toDouble).ceil).toInt + 1) {
      while (j % k == 0) {
        res = res :+ k
        j = j / k
      }
    }

    if (j > 1) res = res :+ j

    res
  }
}
