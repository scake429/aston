package factorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestFactorial {
    @Test
    @DisplayName("Check factorial 7!")
    void checkFactorial_7() throws  Exception {
        assertEquals(5040, Factorial.calc(7), "Factorial 7! should equal 5040");
    }
    @DisplayName("Check factorial 0!")
    void checkFactorial_0() throws  Exception {
        assertEquals(1, Factorial.calc(0), "Factorial 0! should equal 1");
    }
    @DisplayName("Check factorial negative number")
    void checkFactorial_exception() throws  Exception {
        Exception exc = assertThrows(Exception.class, () -> Factorial.calc(-5));
        assertEquals("The factorial is defined only for natural numbers.", exc.getMessage());
    }
}
