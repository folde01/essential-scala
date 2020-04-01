package examples
import java.util.Date

trait Visitor {
  def id: String
  // Unique id assigned to each user
  def createdAt: Date // Date this user first visited the site
  // How long has this visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime
}

case class Anonymous(
                      id: String,
                      createdAt: Date = new Date()
                    ) extends Visitor
case class User(
                 id: String,
                 email: String,
                 createdAt: Date = new Date()
               ) extends Visitor

case class Foo(
              id: String,
              createdAt: Date = new Date(),
              override val age: Long = 1
               ) extends Visitor




object Chapter04ModellingData extends App {

  def older(v1: Visitor, v2: Visitor): Boolean =
    v1.createdAt.before(v2.createdAt)

  val res = older(Anonymous("1"), User("2", "test@example.com"))
  println(res)

}
