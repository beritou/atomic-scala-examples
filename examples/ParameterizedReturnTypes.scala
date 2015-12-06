// ParameterizedReturnTypes.scala
import com.atomicscala.AtomicTest._

// Return type is inferred:
def inferred(c1:Char, c2:Char, c3:Char)={
  Vector(c1, c2, c3)
}

// Explicit return type:
def explicit(c1:Char, c2:Char, c3:Char): Vector[Char] = {
  Vector(c1, c2, c3)
}

def explicitDouble(c1:Double, c2:Double, c3:Double): Vector[Double] = {
  Vector(c1, c2, c3)
}

def explicitList(vector:Vector[Double]): List[Double] = {
 vector.toList
}

def explicitSet(vector:Vector[Double]): Set[Double] = {
 vector.toSet
}

inferred('a', 'b', 'c') is "Vector(a, b, c)"
explicit('a', 'b', 'c') is "Vector(a, b, c)"

explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)

explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)
explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)

explicitSet(Vector(10.0, 20.0, 10.0)) is Set(10.0, 20.0)
explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)
