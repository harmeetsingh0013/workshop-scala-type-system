abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel
case class IronMan(team: String) extends Marvel
case class Thor(team: String) extends Marvel

case class FanClub[T](name: String)

def drStrangeFanClub(club: FanClub[DrStrange]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 50% discount on Dr. Strange Movies")
}
def hulkFanClub(club: FanClub[Hulk]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 40% discount on Hulk Movies")
}
def ironManFanClub(club: FanClub[IronMan]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 60% discount on Iron Man Movies")
}
def thorFanClub(club: FanClub[Thor]): Unit = {
    println(s"We are really happy, you join our club. After your membership," +
        s"you could take a 55% discount on Thor Movies")
}

val drStrangeClub = FanClub[DrStrange]("Wizards")
val hulkClub = FanClub[Hulk]("Go Green")

drStrangeFanClub(drStrangeClub)
//drStrangeFanClub(hulkClub)