// Problems with upper bound

// Go to example 10

abstract class Fruit { def name: String }

class Orange extends Fruit { def name = "Orange" }

class Apple extends Fruit { def name = "Apple" }

class Box[F <: Fruit](aFruit: F) {
    def fruit: F = aFruit

    def contains(aFruit: F) = fruit.name == aFruit.name
}

var appleBox = new Box[Apple](new Apple)

var orangeBox = new Box[Orange](new Orange)

// Now the problem is, what if we require create a new method
// which replace from apple on orange box

//val fruit : Box[Fruit] = new Box[Apple](new Apple)