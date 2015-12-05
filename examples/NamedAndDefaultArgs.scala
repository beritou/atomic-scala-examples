// NamedAndDefaultArgs.scala
import com.atomicscala.AtomicTest._

class SimpleTime(val hours:Int, val minutes:Int) {
  def subtract(t3: SimpleTime):SimpleTime = {
    val timeDiffMinutes = (hours * 60 + minutes) - (t3.hours * 60 + t3.minutes)
    if (timeDiffMinutes < 0)
      new SimpleTime(0,0)
    else
      new SimpleTime((timeDiffMinutes / 60), timeDiffMinutes % 60)
  }
}

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

val t1 = new SimpleTime(10, 30)
val t3 = new SimpleTime(9, 30)
val st = t1.subtract(t3)

st.hours is 1
st.minutes is 0
val st2 = new SimpleTime(10, 30).
  subtract(new SimpleTime(9, 45))
st2.hours is 0
st2.minutes is 45
val st3 = new SimpleTime(9, 30).
  subtract(new SimpleTime(10, 0))
st3.hours is 0
st3.minutes is 0

class SimpleTimeDefault(val hours:Int, val minutes:Int = 0) {
  def subtract(t3: SimpleTimeDefault):SimpleTimeDefault = {
    val timeDiffMinutes = (hours * 60 + minutes) - (t3.hours * 60 + t3.minutes)
    if (timeDiffMinutes < 0)
      new SimpleTimeDefault(0,0)
    else
      new SimpleTimeDefault((timeDiffMinutes / 60), timeDiffMinutes % 60)
  }
}

val anotherT1 =
  new SimpleTimeDefault(10, 30)
val anotherT2 = new SimpleTimeDefault(9)
val anotherST =
  anotherT1.subtract(anotherT2)
anotherST.hours is 1
anotherST.minutes is 30
val anotherST2 = new SimpleTimeDefault(10).
  subtract(new SimpleTimeDefault(9, 45))
anotherST2.hours is 0
anotherST2.minutes is 15

class SimpleTimeAux(val hours:Int, val minutes:Int) {
  def this (hours:Int) {
    this(hours, 0)
  }

  def subtract(t3: SimpleTimeAux):SimpleTimeAux = {
    val timeDiffMinutes = (hours * 60 + minutes) - (t3.hours * 60 + t3.minutes)
    if (timeDiffMinutes < 0)
      new SimpleTimeAux(0,0)
    else
      new SimpleTimeAux((timeDiffMinutes / 60), timeDiffMinutes % 60)
  }
}

val auxT1 = new SimpleTimeAux(10, 5)
val auxT2 = new SimpleTimeAux(6)
val auxST = auxT1.subtract(auxT2)
auxST.hours is 4
auxST.minutes is 5
val auxST2= new SimpleTimeAux(12).subtract(
  new SimpleTimeAux(9, 45))
auxST2.hours is 2
auxST2.minutes is 15
