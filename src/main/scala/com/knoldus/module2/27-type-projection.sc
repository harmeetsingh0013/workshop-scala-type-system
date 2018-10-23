// path dependent and type projection

class Outer {
    trait Inner
    def y = new Inner {}
    def foo(x: this.Inner) = null // this.Inner is called path dependent
    def bar(x: Outer#Inner) = null //Outer#Inner is called type projection
}

val x = new Outer

val y = new Outer

val xin : x.Inner = x.y

x.foo(xin)

x.bar(xin)

//x.bar(y.y)

// Note: All path dependent types are actually based on
// type projection

class OuterP {
    trait Inner
    def y = new Inner {}
    def foo(x: OuterP.this.type#Inner) = null
    def bar(x: OuterP#Inner) = null
}

val xp = new OuterP

val yp = new OuterP

xp.foo(xp.y)

xp.bar(xp.y)

//xp.foo(yp.y)

// Quiz
class AnotherClass(o: Outer) {

    def foo(inner: o.type#Inner) = null

    def bar(inner: Outer#Inner) = null

    def callingFoo = foo(o.y)
}

new AnotherClass(x).callingFoo
//new AnotherClass(x).foo(x.y)
//new AnotherClass(x).bar(x.y)