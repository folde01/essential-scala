package exercises.ch5sequences.s1generics

object GenericList extends App {

  sealed trait IntList

  case object End extends IntList

  final case class Pair(head: Int, tail: IntList) extends IntList

  val a = Pair(1, End)
  println(a)


  sealed trait LinkedList[A] {
    def length: Int = this match {
      case LinkedEnd() => 0
      case LinkedPair(head, tail) => 1 + tail.length
    }
  }

  final case class LinkedEnd[A]() extends LinkedList[A]

  final case class LinkedPair[A](head: Int, tail: LinkedList[A]) extends LinkedList[A]

  val b = LinkedPair[Int](1, LinkedEnd())
  println(b)

  val example = LinkedPair(1, LinkedPair(2, LinkedPair(3, LinkedEnd())))
  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(LinkedEnd().length == 0)
  println("tests done")
}
