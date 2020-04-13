package exercises.ch4modelling.s6recursiveData

object patmatTree extends App {
  sealed trait Tree {
    def sum: Int = this match {
      case Leaf(el) => el
      case Node(l, r) => l.sum + r.sum
    }
  }
  final case class Node(left: Tree, right: Tree) extends Tree
  final case class Leaf(element: Int) extends Tree

  assert(Leaf(1).sum == 1)
  assert(Node(Leaf(1), Leaf(2)).sum == 3)
  assert(Node(Leaf(1), Node(Leaf(1), Leaf(2))).sum == 4)
  assert(Node(Node(Leaf(1), Node(Leaf(1), Leaf(2))),  Node(Leaf(1), Leaf(2))).sum == 7)

}



object polymorphismTree extends App {
  sealed trait Tree {
    def sum: Int
  }
  final case class Node(left: Tree, right: Tree) extends Tree {
    def sum: Int = left.sum + right.sum
  }
  final case class Leaf(element: Int) extends Tree {
    def sum: Int = element
  }

  assert(Leaf(1).sum == 1)
  assert(Node(Leaf(1), Leaf(2)).sum == 3)
  assert(Node(Leaf(1), Node(Leaf(1), Leaf(2))).sum == 4)
  assert(Node(Node(Leaf(1), Node(Leaf(1), Leaf(2))),  Node(Leaf(1), Leaf(2))).sum == 7)
}

