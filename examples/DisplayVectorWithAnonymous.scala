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



var s = ""
val v2 = Vector(1, 5, 7, 8)
v2.foreach(n => s = s"$s${dogYears(n)} ")
s is "7 35 49 56 "

var s3 = ""
val v3 = Vector(1, 5, 7, 8)
v3.foreach(n => s3 = s"$s3${n * 7} ")
s3 is "7 35 49 56 "