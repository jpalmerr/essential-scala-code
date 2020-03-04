package part3

import films.{Director, Film}

object Exercise16bOptionFoldAndMap {
  def directorWithLastName(directors: List[Director], lastName: String): Option[Director] = {
    directors.find(_.lastName == lastName)
  }

  def directorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, Director] = {
    directorWithLastName(directors, lastName).toRight("Error")
  }

  def yearOfBirthOfDirectorWithLastName(directors: List[Director], lastName: String): Option[Int] = {
    directorWithLastName(directors, lastName).map(_.yearOfBirth)
  }

  def yearOfBirthOfDirectorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, Int] = {
    yearOfBirthOfDirectorWithLastName(directors, lastName).toRight("Error")
  }

  def namesOfFilmsByDirectorWithLastName(directors: List[Director], lastName: String): List[String] = {
    val listOfDirectorsWithLastName: List[Director] = directorWithLastName(directors, lastName).toList
    val listOfFilmsByDirector: List[Film] = listOfDirectorsWithLastName.flatMap(_.films)
    listOfFilmsByDirector.map(_.name)
  }

  def main(args: Array[String]): Unit = {
    import films.TestData._

    println("directorWithLastName")
     println(directorWithLastName(directors, "Nolan"))
     println(directorWithLastName(directors, "Guy"))
     println(directorWithLastName(directors, "DROP TABLE *;"))

    println("directorWithLastNameOrFailure")
     println(directorWithLastNameOrFailure(directors, "Nolan"))
     println(directorWithLastNameOrFailure(directors, "Guy"))
     println(directorWithLastNameOrFailure(directors, "DROP TABLE *;"))

    println("yearOfBirthOfDirectorWithLastName")
     println(yearOfBirthOfDirectorWithLastName(directors, "Nolan"))
     println(yearOfBirthOfDirectorWithLastName(directors, "Guy"))
     println(yearOfBirthOfDirectorWithLastName(directors, "DROP TABLE *;"))

    println("yearOfBirthOfDirectorWithLastNameOrFailure")
     println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Nolan"))
     println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Guy"))
     println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "DROP TABLE *;"))

    println("namesOfFilmsByDirectorWithLastName")
    println(namesOfFilmsByDirectorWithLastName(directors, "Nolan"))
    println("SHOULD BE List(Memento, Dark Knight, Inception)")
    println(namesOfFilmsByDirectorWithLastName(directors, "Guy"))
    println(namesOfFilmsByDirectorWithLastName(directors, "DROP TABLE *;"))
  }
}
