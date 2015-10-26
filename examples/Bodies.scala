package com.bodies

class NoBody {
  val nb = new NoBody
}

class SomeBody {
  val name = "Janet Doe"
  println(name + " is SomeBody")
}

class EveryBody {
  val all = Vector(new SomeBody,
    new SomeBody, new SomeBody)
}

