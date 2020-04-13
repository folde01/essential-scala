package exercises.ch4modelling.s7extendedExamples

sealed trait Expression {
  def eval: Calculation = this match {
    case Number(value) => Success(value)
    case Addition(left, right) => Success(left.eval + right.eval)
    case Subtraction(left, right) => left.eval - right.eval
//    case Division(left, right) => right match {
//      case Number(0) =>
//        left.eval / right.eval
//    }
  }
}
final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class Number(value: Double) extends Expression
final case class SquareRoot(value: Double) extends Expression

sealed trait Calculation
final case class Success(value: Double) extends Calculation
final case class Failure(reason: String) extends Calculation

