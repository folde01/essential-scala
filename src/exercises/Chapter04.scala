package exercises

trait Feline {
  def colour: String
  def sound: String = this match {
    case _: Cat => "meow"
    case _ => "roar"
  }
}

case class Cat(
              colour: String,
              food: String
              ) extends Feline

case class Lion(
                colour: String,
                maneSize: Int
              ) extends Feline

case class Tiger(
                 colour: String,
               ) extends Feline

case class Panther(
                  colour: String,
                ) extends Feline

object Chapter04 extends App {
  val cat = Cat("blue", "mice")
  println(cat.sound)
  val lion = Lion("red", 10)
  println(lion.sound)
}

