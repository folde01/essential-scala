package exercises.ch4modelling.s6recursiveData

sealed trait Tree
final case class Node(left: Tree, right: Tree) extends Tree
final case class Leaf(element: Int) extends Tree

