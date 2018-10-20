
// First go to 06-invariance-benifits.java scratch

val comics: Array[String] = Array("IronMan", "Hulk", "DrStrange")
val objects: Array[AnyRef] = comics.asInstanceOf[Array[AnyRef]]
objects(0) = new AnyRef
println(objects)