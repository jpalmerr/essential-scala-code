package calculators

import scala.math.sqrt

object OptionCalculator {

  def main(args: Array[String]): Unit = {

  }

  def run(operator: Operator): Option[Double] = {
    operator match {
      case Addition(left, right) =>
        for {
          x <- operate(left)
          y <- operate(right)
        } yield x + y

      case Subtraction(left, right) =>
        for {
          x <- operate(left)
          y <- operate(right)
        } yield x - y

      case Multiplication(left, right) =>
        for {
          x <- operate(left)
          y <- operate(right)
        } yield x * y

      case Division(left, right) =>
        for {
          x <- operate(left)
          y <- operate(right)
          result <- if (y == 0) None else Some(x / y)
        } yield result

      case SquareRoot(op) =>
        for {
          value: Double <- operate(op)
        } yield sqrt(value)
    }
  }

  def operate(operand: Operand): Option[Double] = {
    operand match {
      case Expression(operator) => run(operator)
      case Number(value) => Some(value)
    }
  }

}
