val valor = 110;

val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

fibs
20.
fibs take 20 toList

var s = 123 toDouble


List(1,2,3).tails



def qsort(list: List[Int]): List[Int] = list match {
  case Nil => Nil
  case pivot :: tail =>
    val (smaller, rest) = tail.partition(_ < pivot)
    qsort(smaller) ::: pivot :: qsort(rest)
}



