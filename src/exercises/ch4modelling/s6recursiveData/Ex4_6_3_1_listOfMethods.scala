package exercises.ch4modelling.s6recursiveData

sealed trait IntList {
  def length: Int = this match {
    case End => 0
    case Pair(h: Int, t: IntList) => 1 + t.length
  }
}
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

object foo extends App {

  val example = Pair(1, Pair(2, Pair(3, End)))
  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)
}
