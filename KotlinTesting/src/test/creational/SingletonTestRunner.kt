package Singleton

import Test.Creational.SingletonTestCase.allCreatedInstanceIsSame
import Test.Creational.SingletonTestCase.booleanMessage
import Test.Creational.SingletonTestCase.isSame
import Test.Creational.SingletonTestCase.objectExists
import `Design Patterns`.Creational.Singleton.Singleton
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