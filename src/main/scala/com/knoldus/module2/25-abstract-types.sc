// Use case of abstract types

case object Grass
case object Flesh

trait Animal {
    type SuitableFood
    def eat(food: SuitableFood) = println(s"I like to eat $food")
}

class Cow extends Animal {
    override type SuitableFood = Grass.type
}

class Lion extends Animal {
    override type SuitableFood = Flesh.type
}

new Cow().eat(Grass)
new Lion().eat(Flesh)

// Using Type Parameters

trait AnimalP[T] {
    def eat(food: T) = println(s"I like to eat $food")
}

class CowP extends AnimalP[Grass.type]

class LionP extends AnimalP[Flesh.type]

new CowP().eat(Grass)
new LionP().eat(Flesh)