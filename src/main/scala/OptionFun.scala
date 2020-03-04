class OptionFun {
  // create an option containing the value 41
  // store the option
  // add 1 to the value in the option
  // store in opt2

  val opt1: Option[Int] = Some(41)

  val opt2: Option[Int] = opt1 match {
    case Some(value) => Some(value + 1)
    case None => None
  }

  val opt3: Option[Int] = opt1.map(_ + 1)
}
