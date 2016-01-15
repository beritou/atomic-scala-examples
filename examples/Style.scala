// Style.scala
import com.atomicscala.AtomicTest._

class Exclaim(var s: String) {
  def noParens = s + "!"
  def parens() = s + "!"
}
val e = new Exclaim("yes")
e.noParens is "yes!"
e.parens() is "yes!"

class Exclaim2(var s: String) {
  val noParens = s + "!"
  def parens() = s + "!"
}
val e2 = new Exclaim2("yes")
e2.noParens is "yes!"
e2.parens() is "yes!"
