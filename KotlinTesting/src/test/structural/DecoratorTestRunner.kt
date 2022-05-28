package Decorator

import org.junit.Test

import java.util.logging.Logger
import kotlin.test.assertTrue

class DecoratorTestRunner {
    private val logger = Logger.getLogger(DecoratorTestRunner::class.java.name)
    @Test
    fun rectangleIsShape() {
        val newRectangle: ShapesDecorator = object : ShapesDecorator(Rectangle()) {}
        assertTrue(newRectangle is Shape)
        logger.info("Rectangle is an instance of Shape")
    }

    @Test
    fun circleIsShape() {
        val newCircle = object : ShapesDecorator(Circle()) {}
        assertTrue(newCircle is Shape)
        logger.info("Circle is an instance of Shape")
    }

    @Test
    fun decoratorIsShape() {
        val newShapeDecorator = object : ShapesDecorator(Rectangle()) {}
        assertTrue(newShapeDecorator is Shape)
        logger.info("newShapeDecorator is an instance of Shape")
    }

    @Test
    fun redShapeDecoratorIsShape() {
        val newRedShapeDecorator = object : RedShapeDecorator(Rectangle()) {}
        assertTrue(newRedShapeDecorator is Shape)
        logger.info("redShapeDecorator is an instance of Shape")
    }
}