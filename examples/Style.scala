// Style.scala
import com.atomicscala.AtomicTest._

class Exclaim3(var s: String) {
  def noParens = s + "!"
}
val e = new Exclaim3("yes")
e.noParens is "yes!"

class Exclaim2(var s: String) {
  val noParens = s + "!"
  def parens() = s + "!"
}
val e2 = new Exclaim2("yes")
e2.noParens is "yes!"
e2.parens() is "yes!"

class Exclaim4(var s: String) {
  var count = 0
  def noParens() = {
    count +=1
    s + "!"
  }
}
val e4 = new Exclaim4("counting")
e4.noParens()
e4.noParens()
e4.count is 2
