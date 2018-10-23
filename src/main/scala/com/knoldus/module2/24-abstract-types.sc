// Type alias

type User = String
type Age = Int

val data: Map[User, Age] = Map("knoldus" -> 6)

// abstract types

trait SimplestContainer {
    type A

    def value: A
}

object IntContainer extends SimplestContainer {
    override type A = Int

    override def value: A = 13
}

IntContainer.value

// Difference between Abstract Types and Parameterization

// -- Abstract Types

type Database = Array[Byte]
type File = Char

abstract class Reader {
    type In
    val source: In
    def read: String
}

class StringReader(val source: String) extends Reader {
    type In = String

    override def read : String = source
}

class DatabaseReader(val source: Database) extends Reader {
    type In = Database

    override def read : String = s"Hello I am Database Reader with ${source.toString} value"
}

class FileReader(val source: File) extends Reader {
    type In = File

    override def read : String = s"Hello I am File Reader with ${source.toString} value"
}

new StringReader("Hello I am String reader").read

new DatabaseReader(Array[Byte](25, 54, 1, 1))

new FileReader('c').read

// -- Parameterize Types

abstract class ReaderP[In] {
    val source: In

    def read: String
}

class StringReaderP(val source: String) extends ReaderP[String] {
    override def read : String = source
}