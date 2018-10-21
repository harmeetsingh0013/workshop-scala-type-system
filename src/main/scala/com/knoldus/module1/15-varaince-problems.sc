trait Combine[T] {
    val item: T
    def combineWith(value: T): T
}

case class CombineInt(item: Int) extends Combine[Int] {
    override def combineWith(value : Int) : Int = item + value
}

val combineInt : Combine[Int] = CombineInt(10)
combineInt.combineWith(20)

// Problem: What if Combine declare with co-variance not contra-variance ???

trait Combine1[+T] {
    val item: T
    def combineWith(value: Int): T // If this possbile
}

case class CombineInt1(item: Int) extends Combine1[Int] {
    override def combineWith(value : Int) : Int = item + value
}

val combineInt1 : Combine1[Any] = CombineInt1(10)


