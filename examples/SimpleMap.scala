// SimpleMap.scala
import com.atomicscala.AtomicTest._

import scala.collection.immutable.VectorBuilder

val v = Vector(1, 2, 3, 4)
v.map(n => n + 1) is Vector(2, 3, 4, 5)

val v2 = Vector(1, 2, 3, 4)
v2.map(n => n * 11 + 10) is Vector(21, 32, 43, 54)

val v3 = Vector(1, 2, 3, 4)
var vec = Vector[Int]()
//no worky
//v3.foreach(n => vec = vec ++ Vector(n * 11 + 10)) is Vector(21, 32, 43, 54)

val v4 = Vector(1, 2, 3, 4)
var vecbuild = new VectorBuilder[Int]
for (n <- v4)
  vecbuild += n * 11 + 10

vecbuild.result is Vector(21, 32, 43, 54)



