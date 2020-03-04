package part3

import films.Film

object Exercise17FoldLeftAndRight {
  def totalImdbRating(films: List[Film]): Double = {
    films.map(_.imdbRating).sum
  }

  def averageImdbRating(films: List[Film]): Double = {
    totalImdbRating(films) / films.length
  }

  def reverseUsingFold[A](items: List[A]): List[A] = {
     // items.reverse
    items.foldLeft(List.empty[A])((a, b) => b :: a )
  }

  def filterUsingFold[A](items: List[A], pred: A => Boolean): List[A] = {
    ???
  }

  def main(args: Array[String]): Unit = {
    import films.TestData._

    println("totalImdbRating")
     println(totalImdbRating(List(memento, outlawJoseyWales, thomasCrownAffair)))
     println(totalImdbRating(Nil))

    println("averageImdbRating")
     println(averageImdbRating(List(memento, outlawJoseyWales, thomasCrownAffair)))
     println(averageImdbRating(Nil))

    println("reverseUsingFold")
     println(reverseUsingFold(List(1, 2, 3)))
     println(reverseUsingFold(Nil))

    println("filterUsingFold")
     println(filterUsingFold(List(1, 2, 3, 4, 5), (n: Int) => n % 2 == 0))
     println(filterUsingFold(Nil, (n: Int) => n % 2 == 0))
  }
}
