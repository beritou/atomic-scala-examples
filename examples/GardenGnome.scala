// GardenGnome.scala
import com.atomicscala.AtomicTest._

class GardenGnome(val height:Double,
  val weight:Double, val happy:Boolean) {
  println("Inside primary constructor")
  var painted = true
  def magic(level:Int):String = {
    s"Poof! $level"
  }
  def this(height:Double) {
    this(height, 100.0, true)
  }
  def this(name:String) = {
    this(15.0)
    painted is true
  }
  def show():String = {
    s"$height $weight $happy $painted"
  }
  def show(level:Int) = {
    s"${magic(level)} $happy $painted"
  }
}

new GardenGnome(20.0, 110.0, false).
show() is "20.0 110.0 false true"
new GardenGnome("Bob").show() is "15.0 100.0 true true"

val gnome = new GardenGnome(20.0, 50.0, false)
gnome.show(87) is "Poof! 87 false true"
val bob = new GardenGnome("Bob")
bob.show(25) is "Poof! 25 true true"

class GardenGnome2(val height:Double,
  val weight:Double, val happy:Boolean) {
  println("Inside primary constructor")
  var painted = true
  def magic(level:Int):String = {
    s"Poof! $level"
  }
  def this(height:Double) {
    this(height, 100.0, true)
  }
  def this(name:String) = {
    this(15.0)
    painted is true
  }
  def show():String = {
    (happy, painted) match{
      case (true,true) => s"height: $height weight: $weight $happy $painted"
      case _ => s"height: $height weight: $weight happy: $happy painted: $painted"
    }
  }
  def show(level:Int) = {
    s"${magic(level)} $happy $painted"
  }
}


val gnome2 =
  new GardenGnome2(20.0, 110.0, false)
gnome2.show() is "height: 20.0 " + "weight: 110.0 happy: false painted: true"
val bob2 = new GardenGnome2("Bob")
bob2.show() is "height: 15.0 weight: 100.0 true true"
