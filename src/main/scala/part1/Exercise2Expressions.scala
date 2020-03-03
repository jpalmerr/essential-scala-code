package part1

import scala.annotation.tailrec

object Exercise2Expressions {
  def greet(name: String): Unit = {
    println(s"Hello ${name}!")
  }

  def greeting(name: String): String = {
    s"Hello ${name}!"
  }

  // Hint - You can reverse a string with `string.reverse`
  def palindrome(str: String): Boolean = {
    str == str.reverse
  }

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n -1)
  }

  // to prevent stack overflow
  def tailRecFactorial(n: Int): Int =
  {
    @tailrec
    def factorialAcc(accum: Int, n: Int): Int =
    {
      if (n <= 1)
        accum
      else
        factorialAcc(n * accum, n - 1)
    }
    factorialAcc(1, n)
  }


  def main(args: Array[String]): Unit = {
    println("greet")
     println(greet("Earthlings"))

    println("greeting")
    println(greeting("Earthlings"))

    println("palindrome")
     println(palindrome("abcba"))
     println(palindrome("taco"))

    println("factorial")
     println(factorial(10))

    println("tailRecfactorial")
    println(factorial(10))
  }
}
