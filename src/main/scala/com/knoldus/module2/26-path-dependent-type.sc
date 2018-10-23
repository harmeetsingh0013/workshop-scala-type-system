// path dependent types

class A {
    class B
}

val a1: A = new A
val b1: a1.B = new a1.B

val a2: A = new A

// Quizz = Which will be compiles ???
//val b2: a2.B = new a1.B
//val b3: a2.B = new a2.B
//val b4: a1.B = new a2.B

// Another Example:

class Parent {
    class Child
    def kids = new Child
}

class ChildrenContainer(val p: Parent) {
    type ChildOfThisParentOnly = p.Child

    def admission(c: ChildOfThisParentOnly): Unit = {
        println(c)
    }

    def registerName = admission(p.kids)
}

val parent1 = new Parent
val parent2 = new Parent

val kinderGarden = new ChildrenContainer(parent1)
kinderGarden.registerName

// Quiz: What will happen this time???
//kinderGarden.admission(parent1.kids)
//kinderGarden.admission(parent2.kids)