package exercises.ch4modelling.s7extendedExamples.calculator

import exercises.ch4modelling.s7extendedExamples.calculator.Calculator.Success

object Calculator extends App {
  sealed trait Expression {
    def eval: Calculation = this match {
      case Number(value) => Success(value)
      case Division(left: Expression, right: Expression) => right.eval match {
        case Success(0) => Failure("Division by zero")
        case _ => Success(left.eval / right.eval)
      }
      case SquareRoot(ex) => ???

      case Addition(left, right) => left.eval match {
        case Failure(msg) => Failure(msg)
        case Success(result1) => right.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result2) => Success(result1 + result2)
        }
      }

      case Subtraction(left, right) => left.eval match {
        case Failure(msg) => Failure(msg)
        case Success(result1) => right.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result2) => Success(result1 - result2)
        }
      }
    }
  }
  final case class Addition(left: Expression, right: Expression) extends Expression
  final case class Subtraction(left: Expression, right: Expression) extends Expression
  final case class Division(left: Expression, right: Expression) extends Expression
  final case class SquareRoot(ex: Expression) extends Expression
  final case class Number(value: Double) extends Expression

  sealed trait Calculation
  final case class Success(result: Double) extends Calculation
  final case class Failure(msg: String) extends Calculation


  val t1 = Number(5)
  assert(t1.eval == 5)
  val t2 = Number(15)
  assert(t2.eval == 15)
  val t3 = Addition(t1, t2)
  assert(t3.eval == 20)
  val t4 = Subtraction(t3, t1)
  assert(t4.eval == 15)

  assert(
    Addition(
      SquareRoot(Number(-1.0)),
      Number(2.0)
    ).eval ==
    Failure("Square root of negative number"))

  assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success (4.0))
  assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))

  println("finished tests")
}
