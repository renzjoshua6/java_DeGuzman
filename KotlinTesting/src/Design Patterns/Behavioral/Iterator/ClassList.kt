package designpatterns.behavioral.iterator

import java.util.HashMap

class ClassList(var classDate: String) : Container {
    var students: Array<String>
    var attendanceDB: HashMap<String, Array<String>>

    init {
        attendanceDB = HashMap()
        run {
            run {
                attendanceDB["May 23"] = arrayOf("Stan", "Renz", "Telle", "Bill")
                attendanceDB["May 24"] = arrayOf()
                attendanceDB["May 25"] = arrayOf("Telle", "Bill")
                attendanceDB.put("May 26", arrayOf("Stan", "Renz", "Telle"))
            }
        }
        students = attendanceDB[classDate]!!
    }

    override val iterator: Iterator
        get() = StudentIterator()

    private inner class StudentIterator : Iterator {
        var index = 0
        override fun hasNext(): Boolean {
            return if (index < students.size) {
                true
            } else false
        }

        override fun next(): Any? {
            return if (hasNext()) {
                students[index++]
            } else null
        }
    }
}