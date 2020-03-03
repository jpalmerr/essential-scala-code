package part1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Exercise2ExpressionsSpec extends AnyFlatSpec with Matchers {
  import Exercise2Expressions._

  "greeting" should "be nice and friendly" in {
//    pending
     greeting("World") should equal("Hello World!")
     greeting("Dave") should equal("Hello Dave!")
  }

  "palindrome" should "seek the tastiest mexican food felines" in {
//    pending
     palindrome("tacocat") should equal(true)
     palindrome("tacobat") should equal(false)
  }

  "factorial" should "multiply some numbers and stuff" in {
//    pending
     factorial(3) should equal (3 * 2 * 1)
     factorial(5) should equal (5 * 4 * 3 * 2 * 1)
  }

  "tailRecfactorial" should "multiply some numbers and stuff" in {
    //    pending
    tailRecFactorial(3) should equal (3 * 2 * 1)
    tailRecFactorial(5) should equal (5 * 4 * 3 * 2 * 1)
  }
}
