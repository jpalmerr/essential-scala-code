package part3

import films.{Director, Film}

object Exercise23HarderProblems {
  def earliestFilmsByAllDirectors(directors: List[Director]): List[(Director, Option[Film])] = {
    for {
      d <- directors
      films = d.films.sortBy(_.yearOfRelease)
    } yield (d, films.headOption)
  }

  def earliestFilmsByAllDirectorsAsMap(directors: List[Director]): Map[Director, Option[Film]] = {
    ???
  }

  def averageImdbRatingAcrossDirectors(directors: List[Director]): Double = {

    val listOfFilms =
      for {
          director     <- directors
          films        <- director.films
        } yield films
    listOfFilms.map(_.imdbRating).sum / listOfFilms.length
  }

  def earliestFilmByAnyDirector(directors: List[Director]): Option[Film] = {
    val listOfFilms: List[Film] = for {
      directorList <- directors
      films        <- directorList.films
    } yield films

    listOfFilms.sortBy(_.yearOfRelease).headOption
  }

  def earliestFilmByOldestDirector(directors: List[Director]): Option[Film] = {
   val oldestDirector = directors.sortBy(_.yearOfBirth).headOption

    for {
      director <- oldestDirector
      films = director.films
      orderedFilms = films.sortBy(_.yearOfRelease)
      oldestFilm <- orderedFilms.headOption
    } yield oldestFilm
  }

  def filmsByAllDirectorsSortedByDirectorNameAndImdb(directors: List[Director], asc: Boolean): List[Film] = {
    // if asc true sort by rating if false sort by directors name

    val listOfFilms: List[Film] = for {
      director <- directors
      films    <- director.films
    } yield films

    if (asc) {
      listOfFilms.sortBy(_.imdbRating)
    } else {
      directors.sortBy(_.name).flatMap(_.films)
    }
  }

  def main(args: Array[String]): Unit = {
    import films.TestData._

    println("earliestFilmsByAllDirectors")
     earliestFilmsByAllDirectors(directors).foreach {
       case (key, value) =>
         println(key + " -> " + value)
     }

    println("earliestFilmsByAllDirectorsAsMap")
    // earliestFilmsByAllDirectorsAsMap(directors).foreach {
    //   case (key, value) =>
    //     println(key + " -> " + value)
    // }

    println("averageImdbRatingAcrossDirectors")
     println(averageImdbRatingAcrossDirectors(directors))

    println("earliestFilmByAnyDirector")
     println(earliestFilmByAnyDirector(directors))

    println("earliestFilmByOldestDirector")
     println(earliestFilmByOldestDirector(directors))

    println("filmsByAllDirectorsSortedByDirectorNameAndImdb asc")
     filmsByAllDirectorsSortedByDirectorNameAndImdb(directors, true).foreach(println)

    println("filmsByAllDirectorsSortedByDirectorNameAndImdb asc")
     filmsByAllDirectorsSortedByDirectorNameAndImdb(directors, false).foreach(println)
  }
}
