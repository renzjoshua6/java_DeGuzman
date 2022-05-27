package Strategy;

import Singleton.SingletonTestRunner;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertEquals;

public class StrategyTestRunner {

    private final Logger logger = Logger.getLogger(StrategyTestRunner.class.getName());
    @Test
    public final void checkSum(){
        Context context = new Context(new OperationAdd());
        int sum = StrategyTestCases.correctSum(1,2);
        assertEquals(sum,context.executeStrategy(1,2));
        this.logger.info("The sum produced is equal");

    }

    @Test
    public final void checkDifference(){
        Context context = new Context(new OperationSubtract());
        int diff = StrategyTestCases.correctDifference(5,3);
        assertEquals(diff,context.executeStrategy(5,3));
        this.logger.info("The difference produced is equal");
    }

    @Test
    public final void checkProduct(){
        Context context = new Context(new OperationMultiply());
        int product = StrategyTestCases.correctProduct(5,3);
        assertEquals(product,context.executeStrategy(5,3));
        this.logger.info("The product produced is equal");
    }

}
