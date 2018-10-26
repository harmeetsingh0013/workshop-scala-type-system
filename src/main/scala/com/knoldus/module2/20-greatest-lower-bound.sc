// Use Cases
// Most of the times, Lower bound is used for handle position of
// covariant types in method arguments

abstract class Fruit { def name: String }

case class Orange() extends Fruit { def name = "Orange" }

case class Apple() extends Fruit { def name = "Apple" }

// Now requirements are :
// I want a method in a box, which replace the fruit, because it is a fruit box
// I want to handle super type of fruit reference box, which contains any subtype fruit boxes

/*class BoxC[F <: Fruit](aFruit: F) {
    val ifruit: F = aFruit
    def replace(fruit: F) = println(s"Now box contains $fruit, instead of $ifruit")
}

val fruitC : BoxC[Fruit] = new BoxC[Apple](Apple())*/

class Box[+F <: Fruit](aFruit: F) {
    val ifruit: F = aFruit
    def replace[U >: F](fruit: U) = {
        println(s"Now box contains $fruit, instead of $ifruit")
    }
}

val fruit : Box[Fruit] = new Box[Apple](Apple())

fruit.replace(new Orange)

fruit.replace(new AnyRef) // What happen with this ???

// The most important example is List[] in scala