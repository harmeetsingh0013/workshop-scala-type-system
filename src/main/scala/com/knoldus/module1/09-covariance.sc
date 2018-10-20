// without co-variance problem

sealed trait Option[T]
case class Some[T](t: T) extends Option[T]
case object None extends Option[Nothing]

//val value: Option[String] = None


// Resolution
/*sealed trait Option[+T]
case class Some[T](t: T) extends Option[T]
case object None extends Option[Nothing]

val value: Option[String] = None*/