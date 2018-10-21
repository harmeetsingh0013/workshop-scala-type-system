abstract class Fruit { def name: String }

case class Orange() extends Fruit { def name = "Orange" }

case class Apple() extends Fruit { def name = "Apple" }

class Box[+F <: Fruit](aFruit: F) {
    val ifruit: F = aFruit
    def replace[M >: F <: Fruit](fruit: M) = {
        println(s"Now box contains $fruit, instead of $ifruit")
    }
}

val fruit : Box[Fruit] = new Box[Apple](Apple())

fruit.replace(new Orange)

//fruit.replace(new AnyRef)