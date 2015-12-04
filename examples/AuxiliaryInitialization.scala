// AuxiliaryInitialization.scala
import com.atomicscala.AtomicTest._

class House(val address:String,
  val state:String, val zip:String) {
  def this(state:String, zip:String) =
    this("address?", state, zip)
  def this(zip:String) =
    this("address?", "state?", zip)
}

class Home(address:String, state:String, zip:String, val name:String) extends House(address, state, zip) {
    override def toString =
      s"$name: $address, $state $zip"
}

class VacationHouse(state:String, zip:String, val startMonth:Int, val endMonth:Int) extends House(state, zip)

class TreeHouse(val name:String, zip:String) extends House(zip)

val h = new Home("888 N. Main St.", "KS",
  "66632", "Metropolis")
h.address is "888 N. Main St."
h.state is "KS"
h.name is "Metropolis"
h is "Metropolis: 888 N. Main St., KS 66632"

val v =
  new VacationHouse("KS", "66632", 6, 8)
v.state is "KS"
v.startMonth is 6
v.endMonth is 8

val tree = new TreeHouse("Oak", "48104")
tree.name is "Oak"
tree.zip is "48104"

class ClothesWasher(val model:String, val capacity:Double) {
  def this(model:String) {
    this(model, 100.0)
  }
  def this(capacity:Double) {
    this("Maytag", capacity)
  }
}

class ClothesWasher2(val model:String = "Maytag", val capacity:Double = 100.0)

val wayOne = new ClothesWasher("Maytag")
val wayTwo = new ClothesWasher2()
wayOne.capacity is wayTwo.capacity
wayOne.model is wayTwo.model

class ClothesWasher3(model:String, capacity:Double) {
  def wash(numBleach:Int = 0, numFabric:Int = 0) =
    (numBleach, numFabric) match {
      case (0,0) => "Simple wash"
      case _ =>  "Wash used " + numBleach + " bleach and " + numFabric + " fabric softener"
    }
}

val washer = new ClothesWasher3("LG 100", 3.6)
washer.wash(2, 1) is "Wash used 2 bleach and 1 fabric softener"
washer.wash() is "Simple wash"
