package factorial;

import org.testng.Assert;
import org.testng.annotations.*;

public class ForCheckFactorialTest {
    @Test
    void checkFactorial_6() throws Exception {
        Assert.assertEquals(720, Factorial.calc(6));
    }

    @Test
    void checkFactorial_0() throws Exception {
        Assert.assertEquals(1, Factorial.calc(0), "The factorial 0! must be equal to 1.");
    }

    @Test
    void checkFactorial_negativeNum() throws Exception {
        Assert.assertThrows(Exception.class, () -> Factorial.calc(-7));
    }

}
