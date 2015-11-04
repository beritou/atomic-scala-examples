// ClassArg.scala
import com.atomicscala.AtomicTest._

class ClassArg(a:Int) {
  println(f)
  def f():Int = { a * 10 }
}

val ca = new ClassArg(19)
ca.f() is 190
// ca.a // error

class Family(names:String*) {
  def familySize(): Int = {
    names.length
  }
}

val family1 = new Family("Mom",
  "Dad", "Sally", "Dick")
family1.familySize() is 4
val family2 =
  new Family("Dad", "Mom", "Harry")
family2.familySize() is 3
