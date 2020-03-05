package calculators

import part3._

import scala.math.sqrt

object Calculator {
  def main(args: Array[String]): Unit = {
    println(run(addition1))
    println(run(addition2))
    println(run(addition3))

    println(run(subtraction1))
    println(run(subtractionAddition))

    println(run(multiplication1))
    println(run(multiplicationSubAdd))

    println(run(division))

  }

  def run(input: Operator): Double = {
    input match {
      case Addition(left, right) => operate(left) + operate(right)
      case Subtraction(left, right) => operate(left) - operate(right)
      case Multiplication(left, right) => operate(left) * operate(right)
      case Division(left, right) => operate(left) / operate(right)
      case SquareRoot(value) => sqrt(operate(value))
    }
  }

  private def operate(operand: Operand): Double = {
    operand match {
      case Expression(op) => run(op)
      case Number(value) => value
    }
  }

  val addition1: Addition = Addition(Number(1.0), Number(2.0)) // 3
  val addition2: Addition = Addition(Number(1.0), Expression(addition1)) // 4
  val addition3: Addition = Addition(Number(1.0), Expression(addition2)) // 5


  val subtraction1: Subtraction = Subtraction(Number(2.0), Number(1.0))
  val subtractionAddition: Subtraction = Subtraction(Number(10.0), Expression(addition3))

  val multiplication1: Multiplication = Multiplication(Number(1.0), Number(2.0))
  val multiplicationSubAdd = Multiplication(Number(10), Expression(subtractionAddition))

  val division: Division = Division(Number(1.0), Number(2.0))

}
