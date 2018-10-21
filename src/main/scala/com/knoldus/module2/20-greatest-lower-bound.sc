// Use Cases
// Most of the times, Lower bound is used for handle position of
// covariant types in method arguments

abstract class Fruit { def name: String }

class Orange extends Fruit { def name = "Orange" }

class Apple extends Fruit { def name = "Apple" }

class Box[+T <: Fruit] {
    def replace[U >: T](fruit: U): Box[T] = { new Box[T] }
}

val fruit : Box[Fruit] = new Box[Apple]

fruit.replace(new Orange)

// The most important example is List[] in scala