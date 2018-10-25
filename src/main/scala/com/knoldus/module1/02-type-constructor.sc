// Class Constructor
case class Animal(a: Int)

// Type Constructor
case class Bowl[T](content: T)

case class Apple()

case class Orange()

case class Kiwi()

val appleBowl : Bowl[Apple] = Bowl(Apple())
val orangeBowl : Bowl[Orange] = Bowl(Orange())