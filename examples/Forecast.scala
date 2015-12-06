import com.atomicscala.AtomicTest._

def forecast(pop: Int): String = {
  pop match {
    case 100 => "Sunny"
    case 80 => "Mostly Sunny"
    case 50 => "Partly Sunny"
    case 20 => "Mostly Cloudy"
    case 0 => "Cloudy"
    case _ => "Unknown"
  }
}

forecast(100) is "Sunny"
forecast(80) is "Mostly Sunny"
forecast(50) is "Partly Sunny"
forecast(20) is "Mostly Cloudy"
forecast(0) is "Cloudy"
forecast(15) is "Unknown"

val sunnyData = Vector(100, 80, 50, 20, 0, 15)
for (d <- sunnyData)
  println (d + " is " + forecast(d))

val weather = Vector(100, 80, 20, 100, 20)

def historicalData(weather: Vector[Int]) = {
  val sunnyDays = weather.count(w => w == 100)
  val mostSunnyDays = weather.count(w => w == 80)
  val mostlyCloudyDays = weather.count(w => w == 20)
  s"Sunny=$sunnyDays, Mostly Sunny=$mostSunnyDays, Mostly Cloudy=$mostlyCloudyDays"
}

historicalData(weather) is "Sunny=2, Mostly Sunny=1, Mostly Cloudy=2"
