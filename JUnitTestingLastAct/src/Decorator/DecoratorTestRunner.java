package Decorator;


import Singleton.SingletonTestCase;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertTrue;

public class DecoratorTestRunner {

    private final Logger logger = Logger.getLogger(DecoratorTestRunner.class.getName());


    @Test
    public final void rectangleIsShape() {
        ShapeDecorator newRectangle = new ShapeDecorator(new Rectangle()) {
        };
        assertTrue(newRectangle instanceof Shape);
        this.logger.info("Rectangle is an instance of Shape");
    }

    @Test
    public final void circleIsShape(){
        ShapeDecorator newCircle = new ShapeDecorator(new Circle()){
        };
        assertTrue(newCircle instanceof Shape);
        this.logger.info("Circle is an instance of Shape");
    }

    @Test
    public final void decoratorIsShape() {
        ShapeDecorator newShapeDecorator = new ShapeDecorator(new Rectangle()) {
        };
        assertTrue(newShapeDecorator instanceof Shape);
        this.logger.info("newShapeDecorator is an instance of Shape");
    }

    @Test
    public final void redShapeDecoratorIsShape() {
        RedShapeDecorator newRedShapeDecorator = new RedShapeDecorator(new Rectangle()) {
        };
        assertTrue(newRedShapeDecorator instanceof Shape);
        this.logger.info("redShapeDecorator is an instance of Shape");
    }


}
