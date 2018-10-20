// Rules of CoVariance
// General Error: covariant type occurs in contravariant position

abstract class Fruit { def name: String }

class Orange extends Fruit { def name = "Orange" }

class Apple extends Fruit {
    def name = "Apple"
    def brand = "Kashmiri"
}

abstract class Box {
    def fruit: Fruit
    def contains(afruit: Fruit) = afruit.name.equals(fruit.name)
}

// Concrete way for creating the boxes of fruits
class OrangeBox (orange: Orange) extends Box {
    override def fruit : Fruit = orange // you can change the return type because of covariance
}

class AppleBox(apple: Apple) extends Box {
    override def fruit : Fruit = apple
}

// Problem with covariance parameter
/*class Box1[+F](ifruit: F) {
    def fruit: F = ifruit
    def contains(aFruit: F) = ???
}*/

// Why compiler generates an error in this position ???
def wrapTheAppleWithBrands(fruit: Fruit): String = {
    val apple = fruit.asInstanceOf[Apple]
    apple.brand
}

wrapTheAppleWithBrands(new Apple)
//wrapTheAppleWithBrands(new Orange)

// Rules of covariance
class Box2[+F](ifruit: F) {
    def fruit: F = ifruit
}

val fruit1 = new Box2[Apple](new Apple).fruit
val fruit2 = new Box2[Orange](new Orange).fruit

// Why above work successfully ???

def wrapTheFruit(fruit: String): Fruit = fruit.toLowerCase match {
    case "orange" => new Orange
    case "apple" => new Apple
    case _ => throw new ClassNotFoundException("Fruit not found")
}

val fruit11 = wrapTheFruit("apple")
