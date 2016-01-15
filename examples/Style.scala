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
