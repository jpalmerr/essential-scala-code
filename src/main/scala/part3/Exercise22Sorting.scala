package part3

import films.{Director, Film}

object Exercise22Sorting {
  def filmsSortedByImdb(films: List[Film]): List[Film] = {
    films.sortBy(_.imdbRating)
  }

  def filmsByDirectorSortedByImdb(director: Director): List[Film] = {
    filmsSortedByImdb(director.films)
  }

  def filmsByAllDirectorsSortedByImdb(directors: List[Director]): List[Film] = {
    filmsSortedByImdb(directors.flatMap(_.films))
  }

  def filmsByAllDirectorsSortedByDirectorNameThenImdb(directors: List[Director]): List[Film] = {
    directors
      .map(d => d.copy(films = filmsSortedByImdb(d.films)))
      .sortBy(f => f.name)
      .flatMap(d => d.films)
  }

  def averageImdbRating(films: List[Film]): Double = {
    films.foldLeft(0.0)(_ + _.imdbRating) / films.length
  }

  def averageImdbRatingAcrossDirectors(directors: List[Director]): Double = {
    val films = directors.flatMap(_.films)
    averageImdbRating(films)
  }

  def main(args:Array[String]): Unit = {
    import films.TestData._

    println("filmsSortedByImdb")
     println(filmsSortedByImdb(mcTiernan.films))
     println(filmsSortedByImdb(eastwood.films))

    println("filmsByDirectorSortedByImdb")
     println(filmsByDirectorSortedByImdb(mcTiernan))
     println(filmsByDirectorSortedByImdb(eastwood))

    println("filmsByAllDirectorsSortedByImdb")
     println(filmsByAllDirectorsSortedByImdb(List(nolan, mcTiernan)))

    println("filmsByAllDirectorsSortedByDirectorNameThenImdb")
     println(filmsByAllDirectorsSortedByDirectorNameThenImdb(List(nolan, mcTiernan)))

    println("averageImdbRating")
     println(averageImdbRating(nolan.films))
     println(averageImdbRating(someGuy.films))

    println("averageImdbRatingAcrossDirectors")
     println(averageImdbRatingAcrossDirectors(directors))
  }
}
