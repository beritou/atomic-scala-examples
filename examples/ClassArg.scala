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

class FlexibleFamily(mom:String, dad:String, kids:String*) {
  def familySize(): Int = {
    2 + kids.length
  }
}

val family3 = new FlexibleFamily(
  "Mom", "Dad", "Sally", "Dick")
family3.familySize() is 4
val family4 =
  new FlexibleFamily("Dad", "Mom", "Harry")
family4.familySize() is 3

val familyNoKids =
  new FlexibleFamily("Mom", "Dad")
familyNoKids.familySize() is 2


def squareThem(numbers:Int*): Int = {
 var total:Int = 0
  for (n <- numbers) {
    total += n * n
 }
  total
  /* could also be implemented like so
  numbers.map(x => x * x).sum
  */
}
squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21
