package Singleton;

import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.AssertJUnit.*;

public class SingletonTestRunner {

    private final Logger logger = Logger.getLogger(SingletonTestRunner.class.getName());

    @Test
    public final void stringIsSame() {
        assertTrue(SingletonTestCase.booleanMessage("This is a Singleton"));
        this.logger.info("Singleton has the same String");
    }

    @Test
    public final void stringIsNotSame() {
        assertFalse(SingletonTestCase.booleanMessage("This is a Singleton"));
        this.logger.info("Singleton does not produce the same String");
    }

    @Test
    public final void instanceExists() {
        assertNotNull(SingletonTestCase.objectExists());
        this.logger.info("The object exists.");
    }

    @Test
    public final void sameObject() {
        assertTrue(SingletonTestCase.isSame());
        this.logger.info("Same Object");
    }

    @Test
    public final void compareInstance() {
        Singleton singleton1 = Singleton.Instance;
        Singleton singleton2 = Singleton.Instance;
        assertTrue(SingletonTestCase.allCreatedInstanceIsSame(singleton1, singleton2));
        this.logger.info("Same Object");
    }
}
