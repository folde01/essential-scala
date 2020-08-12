package exercises.ch5sequences.s1generics

object GenericList extends App {

  sealed trait IntList

  case object End extends IntList

  final case class Pair(head: Int, tail: IntList) extends IntList

  val a = Pair(1, End)
  println(a)




  // 5.1.3.1

  sealed trait LinkedList[A] {
    def length: Int = this match {
      case LinkedEnd() => 0
      case LinkedPair(head, tail) => 1 + tail.length
    }

    def contains(item: A): Boolean = {
      this match {
        case LinkedEnd() => false
        case LinkedPair(head, tail) =>
          if (head == item) true
          else tail.contains(item)
      }
    }
  }
  final case class LinkedEnd[A]() extends LinkedList[A]
  final case class LinkedPair[A](head: Int, tail: LinkedList[A]) extends LinkedList[A]
  val b = LinkedPair[Int](1, LinkedEnd())
  println(b)

  // 5.1.3.2 part 1

  val example = LinkedPair(1, LinkedPair(2, LinkedPair(3, LinkedEnd())))
  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(LinkedEnd().length == 0)
  println("tests done")

  // 5.1.3.2 part 2

  println("ex2")
  val example2 = LinkedPair(1, LinkedPair(2, LinkedPair(3, LinkedEnd[Int]())))
  println("* contains 3?")
  assert(example2.contains(3) == true)
  println("* contains 4?")
  assert(example2.contains(4) == false)
  println("* end contains 0?")
  assert(LinkedEnd[Int]().contains(0) == false)
  // This should not compile
//   example2.contains("not an Int")

}
