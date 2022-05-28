package test.behavioral

import designpatterns.behavioral.iterator.CheckAttendance
import org.junit.Assert
import org.junit.Test

class TestBehavioral {
    @Test
    fun testMay23() {
        Assert.assertEquals("4", CheckAttendance.countPresent("May 23"))
    }

    @Test
    fun testMay24() {
        Assert.assertEquals("0", CheckAttendance.countPresent("May 24"))
    }

    @Test
    fun testMay25() {
        Assert.assertEquals("2", CheckAttendance.countPresent("May 25"))
    }

    @Test
    fun testMay26() {
        Assert.assertEquals("3", CheckAttendance.countPresent("May 26"))
    }

    @Test
    fun testMay27() {
        Assert.assertEquals("null", CheckAttendance.countPresent("May 27"))
    }
}