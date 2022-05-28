package designpatterns.behavioral.iterator

import java.util.logging.Logger

object CheckAttendance {
    private val logger = Logger.getLogger(CheckAttendance::class.java.name)
    fun countPresent(classDate: String): String {

        var count = 0

        println("===== $classDate ====")
        try {
            val classList = ClassList(classDate)
            val iter = classList.iterator
            while (iter.hasNext()) {
                count += 1
                val name = iter.next() as String
                println("$count.) $name")
            }
        } catch (e: NullPointerException) {
            println("Data not available.")
            return e.message.toString()
        }

        if (count == 0) {
            println("No one attended the class.")
        }
        println(" ")

        return count.toString()
    }
}