package Strategy

import Strategy.StrategyTestCases.correctDifference
import Strategy.StrategyTestCases.correctProduct
import Strategy.StrategyTestCases.correctSum
import junit.framework.Assert.assertEquals
import org.junit.Test

import java.util.logging.Logger

class StrategyTestRunner {
    private val logger = Logger.getLogger(StrategyTestRunner::class.java.name)
    @Test
    fun checkSum() {
        val context = Context(OperationAdd())
        val sum = correctSum(1, 2)
        assertEquals(sum, context.executeStrategy(1, 2))
        logger.info("The sum produced is equal")
    }

    @Test
    fun checkDifference() {
        val context = Context(OperationSubtract())
        val diff = correctDifference(5, 3)
        assertEquals(diff, context.executeStrategy(5, 3))
        logger.info("The difference produced is equal")
    }

    @Test
    fun checkProduct() {
        val context = Context(OperationMultiply())
        val product = correctProduct(5, 3)
        assertEquals(product, context.executeStrategy(5, 3))
        logger.info("The product produced is equal")
    }
}