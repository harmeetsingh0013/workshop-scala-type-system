sealed trait User { val id: Int }
case class Member(id: Int, name: String) extends User
case class Admin(id: Int, access: Set[String]) extends User

val data1 : Set[User] = Set(Member(1, "Harmeet"), Member(3, "Knoldus"))
val data2 : Set[User] = Set(Admin(1, Set("Dashboard")), Admin(3, Set("Admin")))
val data3 : Set[User] = Set(Member(1, "James"), Admin(3, Set("Admin")))

// Requirements
/*
We would like to have a function that takes the list of users,
and return a map from id to user… except we would like that map to adjust:
if we pass a set of Users it should return a Map[Int, User],
if we pass a set of Members it should return a Map[Int, Member]
 */

// Version 1
def byId_V1(users: Set[User]): Map[Int, User] =
    users.map(u => u.id -> u).toMap

byId_V1(data1)
byId_V1(data2)
byId_V1(data3)

// Problem: It works, but it is not generic. We wanted it to be generic.

// Version 2
def byId_V2[U](users: Set[U])(getId: U => Int): Map[Int, U] =
    users.map(u => getId(u) -> u).toMap

byId_V2(data1)((u: User) => u.id)
byId_V2(data2)((u: User) => u.id)
byId_V2(data3)((u: User) => u.id)

// Problem: The problem with above code is, we always need to pass HOF manually

// Version 3
def byId_V3[U <: User](users: Set[U]): Map[Int, U] =
    users.map(u => u.id -> u).toMap

byId_V3(data1)
byId_V3(data2)
byId_V3(data3)