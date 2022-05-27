import Decorator.Circle
import Decorator.Rectangle
import Decorator.RedShapeDecorator
import Decorator.Shape

object DecoratorPatternDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        val circle: Shape = Circle()
        val redCircle: RedShapeDecorator = RedShapeDecorator(Circle())
        val redRectangle: RedShapeDecorator = RedShapeDecorator(Rectangle())
        println("Circle with normal border")
        circle.draw()
        println("\nCircle of red border")
        redCircle.draw()
        println("\nRectangle of red border")
        redRectangle.draw()
    }
}