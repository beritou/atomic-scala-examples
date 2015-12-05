// CaseClasses.scala
import com.atomicscala.AtomicTest._

case class Dog(name:String, breed:String="n/a")
val dog1 = Dog("Henry")
val dog2 = Dog("Cleo")
val dogs = Vector(dog1, dog2)
dogs is Vector(Dog("Henry"), Dog("Cleo"))

case class Cat(name:String, age:Int)
val cats =
  Vector(Cat("Miffy", 3), Cat("Rags", 2))
cats is "Vector(Cat(Miffy,3), Cat(Rags,2))"

case class Person(first:String,last:String,email:String)

val p = Person("Jane", "Smile",
  "jane@smile.com")
p.first is "Jane"
p.last is "Smile"
p.email is "jane@smile.com"

val people = Vector(
  Person("Jane","Smile","jane@smile.com"),
  Person("Ron","House","ron@house.com"),
  Person("Sally","Dove","sally@dove.com"))
people(0) is "Person(Jane,Smile,jane@smile.com)"
people(1) is "Person(Ron,House,ron@house.com)"
people(2) is "Person(Sally,Dove,sally@dove.com)"

val dogsWithBreeds = Vector(
  Dog("Fido","Golden Lab"),
  Dog("Ruff","Alaskan Malamute"),
  Dog("Fifi","Miniature Poodle")
)
dogsWithBreeds(0) is "Dog(Fido,Golden Lab)"
dogsWithBreeds(1) is "Dog(Ruff,Alaskan Malamute)"
dogsWithBreeds(2) is "Dog(Fifi,Miniature Poodle)"

case class Dimension(var height:Int, var width:Int)

val c = new Dimension(5,7)
c.height is 5
c.height = 10
c.height is 10
c.width = 19
c.width is 19

case class SimpleTimeDefault(hours:Int, minutes:Int = 0) {
  def subtract(t3: SimpleTimeDefault) = {
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
val anotherST2 =
  new SimpleTimeDefault(10).subtract(
    new SimpleTimeDefault(9, 45))
anotherST2.hours is 0
anotherST2.minutes is 15
