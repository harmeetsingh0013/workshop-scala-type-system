abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

case class FightClub[T <: SuperHero](s1: T, s2: T) {
    override def toString : String =
        s"${s1} and ${s2} start fight ... "
}

val fight1: FightClub[SuperHero] = FightClub(BatMan("JusticeLeague"), Hulk("Avengers"))

case class GameFight[+F <: SuperHero](player: F) {
    override def toString : String =
        s"${player} Ready ... "

    def fight[M >: F <: SuperHero](opponent: M) = FightClub(player, opponent)
}

val game1 =
    GameFight(DrStrange("Avengers"))
        .fight[SuperHero](BatMan("JusticeLeague"))

val game2 =
    GameFight(DrStrange("Avengers"))
        .fight[Marvel](Hulk("Avengers"))