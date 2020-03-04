package part3

import films.{Director, Film}

object Exercise18FlatMap {
  def filmsByDirector(director: Director): List[Film] = {
    director.films
  }

  def namesOfFilmsByDirector(director: Director): List[String] = {
    director.films.map(_.name)
  }

  def filmsByAllDirectors(directors: List[Director]): List[Film] = {
    directors.flatMap(_.films)
  }

  def namesOfFilmsByAllDirectors(directors: List[Director]): List[String] = {
    filmsByAllDirectors(directors).map(_.name)
  }

  // Return a list of messages of the form "Tonight only! <FILM> by <DIRECTOR>!"
  def tonightOnlyMessages(directors: List[Director]): List[String] = {
    directors.flatMap { director =>
      filmsByDirector(director).map { film =>
        s"Tonight only! ${film.name} by ${director.name}!"
      }
    }
  }

  def main(args: Array[String]): Unit = {
    import films.TestData._

    println("filmsByDirector")
     println(filmsByDirector(nolan))
     println(filmsByDirector(mcTiernan))
     println(filmsByDirector(someGuy))

    println("namesOfFilmsByDirector")
     println(namesOfFilmsByDirector(nolan))
     println(namesOfFilmsByDirector(mcTiernan))
     println(namesOfFilmsByDirector(someGuy))

    println("filmsByAllDirectors")
     println(filmsByAllDirectors(List(nolan, mcTiernan)))
     println(filmsByAllDirectors(List(eastwood, someGuy)))

    println("namesOfFilmsByAllDirectors")
     println(namesOfFilmsByAllDirectors(List(nolan, mcTiernan)))
     println(namesOfFilmsByAllDirectors(List(eastwood, someGuy)))

    println("tonightOnlyMessages")
     println(tonightOnlyMessages(List(nolan, mcTiernan)))
  }
}
