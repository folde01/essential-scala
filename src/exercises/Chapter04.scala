package exercises

// 4.1.4.1

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


// 4.1.4.2

trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Circle(radius: Double) extends Shape {
  def sides = 1
  def perimeter = Math.PI * radius * 0.5
  def area = Math.PI * radius * radius
}

case class Rectangle(height: Double, width: Double) extends Shape {
  def sides = 4
  def perimeter = 2 * (height + width)
  def area = height * width
}

case class Square(length: Double) extends Shape {
  val r = Rectangle(length, length)
  def sides = r.sides
  def perimeter = r.perimeter
  def area = r.area
}

// 4.1.4.3

trait Rectangular extends Shape {
  def sides = 4
  def width: Double
  def height: Double
  def perimeter = 2 * (width + height)
  def area = width * height
}

case class Rectangle2(
                       height: Double,
                       width: Double) extends Rectangular

case class Square2(size: Double) extends Rectangular {
  def width = size
  def height = size
}

object Chapter04 extends App {

  // 4.1.4.1
  val cat = Cat("blue", "mice")
  println(cat.sound)
  val lion = Lion("red", 10)
  println(lion.sound)

  // 4.1.4.2
  println(Circle(1).area)
  println(Rectangle(1, 2).perimeter)
  println(Square(2.5).area)

  // 4.1.4.3
  println(Rectangle2(2, 3).area)
  println(Square2(3).perimeter)


}

