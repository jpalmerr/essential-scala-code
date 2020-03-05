package calculators

sealed trait Operand
case class Expression(operator: Operator) extends Operand
case class Number(value: Double) extends Operand

sealed trait Operator
case class Addition(left: Operand, right: Operand) extends Operator
case class Subtraction(left: Operand, right: Operand) extends Operator
case class Multiplication(left: Operand, right: Operand) extends Operator
case class Division(left: Operand, right: Operand) extends Operator
case class SquareRoot(op: Operand) extends Operator
