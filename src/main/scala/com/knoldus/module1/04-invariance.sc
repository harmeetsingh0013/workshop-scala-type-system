abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")

case class Tower[T](superHero: T) {
    override def toString : String = s"This is the ${superHero} tower"
    def helpMe : T = superHero
}

val tower1 : Tower[BatMan] = Tower(batMan)
val tower2 : Tower[Hulk] = Tower(hulk)

def callingToBatCave(tower: Tower[BatMan]): String = {
    s"From tower ${tower.helpMe.team}, hero's will be come for save the day"
}

def callingToStarkTower(tower: Tower[Hulk]): String = {
    s"From tower ${tower.helpMe.team}, hero's will be come for save the day"
}


val team1 = callingToBatCave(tower1)
val team2 = callingToStarkTower(tower2)
