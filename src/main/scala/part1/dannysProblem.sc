/*
take x, divide by 32, put the remainder in the list
divide new number by 32
if x == 0 then return
 */

import scala.math.Integral.Implicits._

def method(input: Int, initialList: List[Int] = List.empty[Int]): List[Int] = {

  val (quo, rem) = input /% 32 // bit of scala syntax but same results as your set up
  val quotient: Int = quo
  val remainder: Int = rem

  if (quotient == 0 ) {
    val newList: List[Int] = initialList ++ List(remainder) // append
    newList
  } else {
    val newList: List[Int] = initialList ++ List(remainder) // append
    method(quotient, newList)
  }
}

method(17466)       // should be: 26, 1, 17
method(4315)        // should be: 27, 6, 4
method(17093)       // should be : 5, 22, 16
method(0)           // should be 0

/*
initialList is whats called a default parameter in scala, imagine r has a similar construct
just means I can also call it like so
 */
method(17466, List())
