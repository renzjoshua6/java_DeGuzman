package designpatterns.behavioral.iterator

import java.util.ArrayList
import java.util.logging.Logger

object CheckAttendance {
    private val logger = Logger.getLogger(CheckAttendance::class.java.name)
    fun countPresent(classDate: String): String {
        val datesAvailable: ArrayList<String?> = object : ArrayList<String?>() {
            init {
                add("May 23")
                add("May 24")
                add("May 25")
                add("May 26")
            }
        }

        var count = 0

        println("===== $classDate ====")
        if (datesAvailable.contains(classDate)) {
            val classList = ClassList(classDate)
            val iter = classList.iterator
            while (iter!!.hasNext()) {
                count += 1
                val name = iter.next() as String
                println("$count.) $name")
            }
        } else {
            println("Data not available.")
            return "NULL"
        }

        if (count == 0) {
            println("No one attended the class.")
        }
        println(" ")

        return count.toString()
    }
}