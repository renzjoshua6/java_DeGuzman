package Decorator

// Abstract class
abstract class ShapesDecorator// This keyword refers to current object itself
// Method 1
// Abstract class method
    (  // Protected variable
    var decoratedShape: Shape?
) : Shape {
    // Method 2 - draw()
    // Outside abstract class
    override fun draw() {
        decoratedShape?.draw()
    }
}