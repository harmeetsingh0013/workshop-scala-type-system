import scala.util.Random

abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel
case class IronMan(team: String) extends Marvel
case class Thor(team: String) extends Marvel

case class FanClub[-T](name: String)

def drStrangeFanClub(club: FanClub[DrStrange]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 30% discount on any superheros movies")
}
def hulkFanClub(club: FanClub[Hulk]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 30% discount on any superheros movies")
}
def ironManFanClub(club: FanClub[IronMan]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 30% discount on any superheros movies")
}
def thorFanClub(club: FanClub[Thor]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 30% discount on any superheros movies")
}

val drStrangeClub = FanClub[DrStrange]("Wizards")
val marvelClub = FanClub[Marvel]("Marvel")
val superHeroClub = FanClub[Marvel]("Super Heros")

drStrangeFanClub(drStrangeClub)
drStrangeFanClub(marvelClub)
drStrangeFanClub(superHeroClub)

val hulkClub = FanClub[Hulk]("Go Green")
hulkFanClub(hulkClub)
hulkFanClub(marvelClub)
hulkFanClub(superHeroClub)