
import static org.junit.jupiter.api.Assertions.*;

import org.example.Calculator;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5.0, calculator.Calculate("2 + 3"));
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(1.0, calculator.Calculate("3 - 2"));
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(6.0, calculator.Calculate("2 * 3"));
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.Calculate("4 / 2"));
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class, () -> calculator.Calculate("4 / 0"));
    }


    @Test
    public void testSquareRoot() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.Calculate("sqrt(4)"));
    }

    @Test
    public void testInvalidInputFormat() {
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class, () -> calculator.Calculate("2 +"));
    }

    @Test
    public void testInvalidNumberFormat() {
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class, () -> calculator.Calculate("2 + abc"));
    }

    @Test
    public void testUndefinedOperation() {
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class, () -> calculator.Calculate("2 ^ 3"));
    }
}

