val opt1: Option[Int] = Some(41)

val opt2: Option[Int] = opt1 match {
  case Some(value) => Some(value + 1)
  case None => None
}

val opt3: Option[Int] = opt1.map(_ + 1)
