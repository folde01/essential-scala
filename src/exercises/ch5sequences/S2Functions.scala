package exercises.ch5sequences


object Examples extends App {

  sealed trait IntList {
    def length: Int =
      this match {
        case End => 0
        case Pair(hd, tl) => 1 + tl.length
      }

    def double: IntList =
      this match {
        case End => End
        case Pair(hd, tl) => Pair(hd * 2, tl.double)
      }

    def product: Int =
      this match {
        case End => 1
        case Pair(hd, tl) => hd * tl.product
      }

    def sum: Int =
      this match {
        case End => 0
        case Pair(hd, tl) => hd + tl.sum
      }

    def fold(end: Int, f: (Int, Int) => Int): Int = this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
  }

  case object End extends IntList

  case class Pair(hd: Int, tl: IntList) extends IntList

  object add1 {
    def apply(n: Int): Int = n + 1
  }
  println(s"add1(2): ${add1(2)}")

  val hi = () => "hi!"
  println(hi)
  println(hi())

  val addd1 = (x: Int) => x + 1
  println(add1(3))

  val sum = (x: Int, y: Int) => (x + y): Int
  println(sum(3, 4))


}



