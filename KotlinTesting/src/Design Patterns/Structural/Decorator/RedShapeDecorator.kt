package Decorator

// Concrete class extending the abstract class
open class RedShapeDecorator(decoratedShape: Shape?) : ShapesDecorator(decoratedShape) {
    override fun draw() {
        decoratedShape?.draw()
        decoratedShape?.let { setRedBorder(it) }
    }

    // Display message whenever function is called
    private fun setRedBorder(decoratedShape: Shape) {
        println("Border Color: Red")
    }
}