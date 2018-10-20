sealed trait Food
class DogFood extends Food

abstract class Animal {
    def seakFood: Food
}

class Dog extends Animal {
    override def seakFood: DogFood = new DogFood
}