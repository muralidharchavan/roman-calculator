package it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.rest.v1.CalculatorInterface;
import application.rest.v1.Router;

public class TestCalculatorInterface {

    @Test
    @DisplayName("Test no parameters")
    public void testNoParameters() {
        CalculatorInterface mockCalculator = mock(CalculatorInterface.class);
        Router router = new Router(mockCalculator);

        assertEquals(400, router.calculate("add", "").getStatus());
        assertEquals("Bad Request", router.calculate("add", "").getEntity().toString());
    }

    @Test
    @DisplayName("Test addition")
    public void testAdd() throws Exception {
        CalculatorInterface mockCalculator = mock(CalculatorInterface.class);
        Router router = new Router(mockCalculator);

        when(mockCalculator.calculate("add", "I,I")).thenReturn("II");
        assertEquals("II", router.calculate("add", "I,I").getEntity().toString());
        assertEquals(200, router.calculate("add", "I,I").getStatus());
    }

    @Test
    @DisplayName("Test valid parameters")
    public void testSubtract() throws Exception {
        CalculatorInterface mockCalculator = mock(CalculatorInterface.class);
        Router router = new Router(mockCalculator);

        when(mockCalculator.calculate("sub", "II,I")).thenReturn("I");
        assertEquals("I", router.calculate("sub", "II,I").getEntity().toString());
        assertEquals(200, router.calculate("sub", "II,I").getStatus());
    }
}
