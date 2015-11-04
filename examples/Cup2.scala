// Cup2.scala
import com.atomicscala.AtomicTest._

class Cup2 (var percentFull: Int = 0, max:Int = 100) {
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    }
    percentFull // Return this value
  }
}

class Cup3 {
  var percentFull = 0
  val max = 100
  val min = 0
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    }
    else if(percentFull < min) percentFull = min 
    percentFull // Return this value
  }
}

class Cup4 {
  var percentFull = 0
  val max = 100
  val min = 0
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    }
    else if(percentFull < min) percentFull = min 
    percentFull // Return this value
  }
  def set(newPercentFull:Int): Unit = percentFull = newPercentFull
  def get():Int = percentFull
}

val cup = new Cup2
cup.add(50) is 50
cup.add(70) is 100

val cup2 = new Cup2
cup2.add(45) is 45
cup2.add(-15) is 30
cup2.add(-50) is -20

val cup3 = new Cup3
cup3.add(45) is 45
cup3.add(-55) is 0
cup3.add(10) is 10
cup3.add(-9) is 1
cup3.add(-2) is 0

cup3.percentFull = 56
cup3.percentFull is 56

val cup4 = new Cup4
cup4.set(56)
cup4.get() is 56

class Cup5 (var percentFull: Int = 0) {
  var max:Int = 100
  def increase(adj:Int*):Int = {
    for (a <- adj) {
      percentFull += a

      if (percentFull > max) {
        percentFull = max

      }
    }
    percentFull // Return this value
  }
}
val cup5 = new Cup5(0)
cup5.increase(20, 30, 50, 20, 10, -10, -40, 10, 50) is 100
cup5.increase(10, 10, -10, 10, 90, 70, -70) is 30
