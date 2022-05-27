package Singleton

import Singleton.SingletonTestCase.allCreatedInstanceIsSame
import Singleton.SingletonTestCase.booleanMessage
import Singleton.SingletonTestCase.isSame
import Singleton.SingletonTestCase.objectExists
import org.junit.Test
import java.util.logging.Logger
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class SingletonTestRunner {
    private val logger = Logger.getLogger(SingletonTestRunner::class.java.name)

    @Test
    fun instanceExists() {
        assertNotNull(objectExists())
        logger.info("The object exists.")
    }

    @Test
    fun stringResultIsSame() {
        assertTrue(booleanMessage("This is a Singleton"))
        logger.info("Singleton has the same String")
    }

    @Test
    fun stringResultIsNotSame() {
        assertFalse(booleanMessage("This is a Singleton"))
        logger.info("Singleton does not produce the same String")
    }

    @Test
    fun sameObject() {
        assertTrue(isSame)
        logger.info("Same Object")
    }

    @Test
    fun compareInstance() {
        val singleton1 = Singleton.Instance
        val singleton2 = Singleton.Instance
        assertTrue(allCreatedInstanceIsSame(singleton1!!, singleton2!!))
        logger.info("Same Object")
    }
}