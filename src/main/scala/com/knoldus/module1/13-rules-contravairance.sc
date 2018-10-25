
class Fruit { def name: String = "" }

class Orange extends Fruit { override def name = "Orange" }

class Apple extends Fruit {
    override def name = "Apple"
    def brand = "Kashmiri"
}

class Box[-T](val aFruit: T) {
    def contains(otherFruit: T): Boolean = aFruit.equals(otherFruit)
}

def brandOfTheApples(appleBox: Box[Apple]): Unit = {
    println(appleBox.aFruit.brand)
}

val appleBox = new Box[Apple](new Apple)
brandOfTheApples(appleBox)