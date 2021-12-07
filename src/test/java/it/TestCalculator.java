package it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.service.CalculatorService;

public class TestCalculator {
    @Test
    @DisplayName("Test add")
    public void testAdd1And2() throws Exception {
        assertEquals(3, CalculatorService.calculate("add", new int[] { 1, 2 }));
    }

    @Test
    @DisplayName("Test subtract")
    public void testSubtract1From2() throws Exception {
        assertEquals(1, CalculatorService.calculate("sub", new int[] { 2, 1 }));
    }

    @Test
    @DisplayName("Test multiply")
    public void testMultiply1And2() throws Exception {
        assertEquals(2, CalculatorService.calculate("mult", new int[] { 1, 2 }));
    }

    @Test
    @DisplayName("Test divide")
    public void testDivide2By1() throws Exception {
        assertEquals(2, CalculatorService.calculate("div", new int[] { 2, 1 }));
    }

    @Test
    @DisplayName("Test some other operation")
    public void testSomeOtherOperation() throws Exception {

        Exception thrown = assertThrows(
                IllegalArgumentException.class,
                () -> CalculatorService.calculate("some", new int[] { 1, 2 }));

        assertTrue(thrown.getMessage().contains("Invalid operation"));
    }

}
