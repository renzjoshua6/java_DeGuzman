package Decorator;

// Concrete class extending the abstract class
public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    // Display message whenever function is called
    private void setRedBorder (Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
