// What is the behaviour of the below code ???
trait A {
    type T
    var t: T
}

case class S(a: Int)

val a1 = new A { type T = S; var t = S(1) }
val a2 = new A { type T = S; var t = S(2) }

def f(a: A) : a.T = a.t

//val x1: a2.T = f(a1)

// Another Example
trait B {
    type T = S
    case class S(a: Int)
    var t: T
}

val b1 = new B { var t = S(1) }
val b2 = new B { var t = S(2) }

def f(b: B) : b.T = b.t

//val x2: b2.T = f(b1)