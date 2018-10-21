// Go to example 4

abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")

// Use cases of Reasons of upper bounds
// -- If we need to access some common property from the type hierarchy

case class Tower[T <: SuperHero](superHero: T) {
    override def toString : String = s"This is the ${superHero.team} tower"
    def helpMe : T = superHero
}

val tower1 : Tower[BatMan] = Tower[BatMan](batMan)
val tower2 : Tower[Hulk] = Tower[Hulk](hulk)

// -- Without lower bound we are not able to restrict with specific type hierarchy

// Take an second example
/*
case class Tower[T](superHero: T) {
    override def toString : String = s"This is the ${superHero} tower"
    def helpMe : T = superHero
}

Tower(10)*/