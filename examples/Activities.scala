// Yielding4.scala
import com.atomicscala.AtomicTest._

case class Activity(date:String,sport:String)

val activities = Vector(
  Activity("01-01", "Run"),
  Activity("01-03", "Ski"),
  Activity("01-04", "Run"),
  Activity("01-10", "Ski"),
  Activity("01-03", "Run"))



def getDates(sport: String, activities: Vector[Activity]) = {
  for {
    activity <- activities
    if (activity.sport == sport)
  } yield activity.date
}

getDates("Ski", activities) is Vector("01-03", "01-10")
getDates("Run", activities) is Vector("01-01", "01-04", "01-03")
getDates("Bike", activities) is Vector()

def getActivities(date: String, activities: Vector[Activity]): Vector[String] = {
  for {
    activity <- activities
    if (activity.date == date)
  } yield activity.sport
}

getActivities("01-01", activities) is Vector("Run")
getActivities("01-02", activities) is Vector()
getActivities("01-03", activities) is Vector("Ski", "Run")
getActivities("01-04", activities) is Vector("Run")
getActivities("01-10", activities) is Vector("Ski")
