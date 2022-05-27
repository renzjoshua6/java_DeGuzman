package Decorator;

// Abstract class
public abstract class ShapeDecorator implements Shape {

    // Protected variable
    protected Shape decoratedShape;

    // Method 1
    // Abstract class method
    public ShapeDecorator(Shape decoratedShape){

        // This keyword refers to current object itself
        this.decoratedShape = decoratedShape;
    }

    // Method 2 - draw()
    // Outside abstract class
    public void draw(){
        decoratedShape.draw();
    }
}
