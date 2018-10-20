def foo(x: Any): String =
    s"Hello ! I received a $x"

def bar(x: String): Any = foo(x)

bar("Test")
foo("Test")

// Create custom Function trait

trait Function[Arg, Return]

val x = new Function[Any, String] {}

//val y: Function[String, Any] = x