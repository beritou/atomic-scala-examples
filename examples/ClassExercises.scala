import com.atomicscala.AtomicTest._

class Dimension(var height:Int, var width:Int)

val c = new Dimension(5,7)
c.height is 5
c.height = 10
c.height is 10
c.width = 19
c.width is 19

class Info(var name:String, var description:String)

val info = new Info("stuff", "Something")
info.name is "stuff"
info.description is "Something"
info.description = "Something else"
info.description is "Something else"
info.name = "This is the new name"
info.name is "This is the new name"

