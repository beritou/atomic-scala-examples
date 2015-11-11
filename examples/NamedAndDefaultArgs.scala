// NamedAndDefaultArgs.scala
import com.atomicscala.AtomicTest._

class SimpleTime(val hours:Int, val minutes:Int)

val t = new SimpleTime(hours=5, minutes=30)
t.hours is 5
t.minutes is 30

class SimpleTime2(val hours:Int, val minutes:Int = 0)

val t2 = new SimpleTime2(hours=10)
t2.hours is 10
t2.minutes is 0

class Planet(name:String,description:String, moons:Int = 1)  {
  val hasMoon = moons > 0
}


val p = new Planet(name = "Mercury",
  description = "small and hot planet",
  moons = 0)
p.hasMoon is false

val earth = new Planet(moons = 1,
  name = "Earth",
  description = "a hospitable planet")
earth.hasMoon is true

class Item(name:String,price:Double) {
  def cost(grocery:Boolean = false, medication:Boolean = false, taxRate:Double = .1):Double = {
    (grocery, medication) match {
      case (true, _) => price
      case _ => price + price * taxRate
    }
  }
}

val flour = new Item(name="flour", 4)
flour.cost(grocery=true) is 4
val sunscreen = new Item(
  name="sunscreen", 3)
sunscreen.cost() is 3.3
val tv = new Item(name="television", 500)
tv.cost(taxRate = 0.06) is 530

//class Color2(red:Int = 100,
//  blue:Int = 100, green:Int = 100)
//new Color2(20)
//new Color2(20, 17)
//new Color2(blue = 20)
//new Color2(red = 11, green = 42)
