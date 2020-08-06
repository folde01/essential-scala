package exercises.ch5sequences.s1generics

object GenericList extends App {

  sealed trait IntList

  case object End extends IntList

  final case class Pair(head: Int, tail: IntList) extends IntList

  val a = Pair(1, End)
  println(a)



  sealed trait LinkedList[A]

  final case class LinkedEnd[A]() extends LinkedList[A]

  final case class LinkedPair[A](head: Int, tail: LinkedList[A]) extends LinkedList[A]

  val b = LinkedPair[Int](1, LinkedEnd())
  println(b)


}
