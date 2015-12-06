// DisplayVectorWithAnonymous.scala

import com.atomicscala.AtomicTest._

val v = Vector(1, 2, 3, 4)
v.foreach(n => println("> " + n))

var str = ""
v.foreach(n => str = str + n)
str is "1234"

str = ""
v.foreach(n => str = str + n + ",")
str is "1,2,3,4,"

val dogYears = (y:Int) => (y * 7)

dogYears(10) is 70
