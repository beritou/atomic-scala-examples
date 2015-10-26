// MatchExpressions.scala
import com.atomicscala.AtomicTest._

def matchColor(color:String):String = {
 if (color == "blue")
   "BLUE"
  else if (color == "white")
   "UNKNOWN COLOR: white"
  else
   "UNKNOWN COLOR " + color
}

matchColor("white") is "UNKNOWN COLOR: white"
matchColor("blue") is "BLUE"
