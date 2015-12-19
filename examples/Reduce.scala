// Reduce.scala
import com.atomicscala.AtomicTest._

val v = Vector(1, 10, 100, 1000)
v.reduce((sum, n) => sum + n) is 1111

var result = 0
for (n <- v)
  result += n
result is 1111

def sumIt(numbers:Int*) = {
  numbers.reduce((x,y) => x + y)
}
sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195

val sumItBetter = (numbers: Seq[Int]) => numbers.reduce((x,y) => x + y)
sumItBetter(Seq(1, 2, 3)) is 6
sumItBetter(Seq(45, 45, 45, 60)) is 195
