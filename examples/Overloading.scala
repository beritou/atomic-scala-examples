// Overloading.scala
import com.atomicscala.AtomicTest._

class Overloading1 {
  def f():Int = { 88 }
  def f(n:Int):Int = { n + 2 }
}

class Overloading2 {
  def f():Int = { 99 }
  def f(n:Int):Int = { n + 3 }
}

val mo1 = new Overloading1
val mo2 = new Overloading2
mo1.f() is 88
mo1.f(11) is 13
mo2.f() is 99
mo2.f(11) is 14


def f() = 0
def f(i:Int) = i
def f(i: Int, j:Int) =  i + j
def f(i: Int, j:Int, k:Int): Int = i + j + k
def f(i: Int, j:Int, k:Int, l:Int) = i + j + k + l

f() is 0
f(1) is 1
f(1, 2) is 3
f(1, 2, 3) is 6
f(1, 2, 3, 4) is 10

class FINAClass {
 def f() = 0
def f(i:Int) = i
def f(i:Int) = "one"
def f(i: Int, j:Int) =  i + j
def f(i: Int, j:Int, k:Int): Int = i + j + k
def f(i: Int, j:Int, k:Int, l:Int) = i + j + k + l
}