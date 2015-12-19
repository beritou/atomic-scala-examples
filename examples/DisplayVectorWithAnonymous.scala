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

val between = ((temp: Int, low: Int, high:Int ) => temp > low && temp < high)

between(70, 80, 90) is false
between(70, 60, 90) is true

var s4 = ""
val numbers = Vector(1, 2, 5, 3, 7)
numbers.foreach(n => s4 = s"$s4${n*n} ")
s4 is "1 4 25 9 49 "

val pluralize = ((word:String) => word + "s")
pluralize("cat") is "cats"
pluralize("dog") is "dogs"
pluralize("silly") is "sillys"

var s5 = ""
val words = Vector("word", "cat", "animal")
words.foreach(word => s5 = s5 + word + "s ")
s5 is "words cats animals "