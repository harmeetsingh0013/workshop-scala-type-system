// Go to example 16

abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

abstract class Tower {
    type SH <: SuperHero
    val superHero: SH
    def teamName: String = s"I am ${superHero.team}"
}

class HulkTower(val superHero: Hulk) extends Tower {
    type SH = Hulk
}

val hulkTower : HulkTower = new HulkTower(Hulk("Avengers"))

// ways to create path dependent and type projection types
val hulk1 = hulkTower.superHero

val hulk2: Hulk = hulkTower.superHero

val hulk3: hulkTower.SH = hulkTower.superHero

val hulk4: HulkTower#SH = hulkTower.superHero