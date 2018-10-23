// Refinement Types: Subclassing without naming the subclass.

trait AbstractLayer {
    def method()
}

val anonymous = new AbstractLayer {
    override def method() : Unit = ()
}


// Refinement types in scala type system
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

// There is another way for creating different types of tower like HulkTower
// with Singleton object

object TowerOfHero{
    def apply[F <: SuperHero](f: F) : Tower { type SH = F } = new Tower {
        override type SH = F
        override val superHero : SH = f
    }
}

// Important Note: Tower { type SH = DrStrange } notation called refinement of type

val drStrangeTower = TowerOfHero(DrStrange("Avengers"))

val hulkTower : Tower { type SH = Hulk } = TowerOfHero(Hulk("Avengers"))

val drStrange1  = drStrangeTower.superHero

val drStrange2: DrStrange = drStrangeTower.superHero

val drStrange3: drStrangeTower.SH  = drStrangeTower.superHero

val drStrange4: Tower#SH  = drStrangeTower.superHero

// Quiz ???

class HulkTower(val superHero: Hulk) extends Tower {
    type SH = Hulk
}

val hulkTower2 : HulkTower = new HulkTower(Hulk("Avengers"))

//val dtStrange5: drStrangeTower.SH = hulkTower2.superHero

//val hulk5: HulkTower#SH = hulkTower.superHero

//val hulk6: HulkTower#SH = hulkTower2.superHero

//val hulk7: hulkTower.SH = hulkTower2.superHero

// Try with Batman ???