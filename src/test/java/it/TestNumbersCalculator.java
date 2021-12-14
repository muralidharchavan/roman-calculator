package it;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.service.CalculatorService;

import org.junit.jupiter.api.Nested;

public class TestNumbersCalculator {

    @Nested
    @DisplayName("Test Addition")
    class TestAddition {
        @Test
        @DisplayName("Test 1+1=2")
        public void test1Plus1Equals2() throws Exception {
            assertEquals("2", CalculatorService.calculate("add", new int[] { 1, 1 }));
            assertEquals("6", CalculatorService.calculate("add", new int[] { 1, 2, 3 }));
        }

        @Test
        @DisplayName("Test invalid addition result ")
        public void testInvalidAdditionResult() throws Exception {
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> CalculatorService.calculate("add", new int[] { 2000, 3000 }));

            assertTrue(thrown.getMessage().contains("Not Implemented"));
        }
    }

    @Nested
    @DisplayName("Test Subtraction")
    class TestSubtraction {

        @Test
        @DisplayName("Test 2-1=1")
        public void test2Minus1() throws Exception {
            assertEquals("1", CalculatorService.calculate("sub", new int[] { 2, 1 }));
            assertEquals("1", CalculatorService.calculate("sub", new int[] { 4, 2, 1 }));
        }

        @Test
        @DisplayName("Test invalid Subtraction ")
        public void testInvalidSubtraction() throws Exception {
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> CalculatorService.calculate("sub", new int[] { 1, 2 }));

            assertTrue(thrown.getMessage().contains("Not Implemented"));
        }

    }

    @Nested
    @DisplayName("Test Multiplication")
    class TestMultiplication {
        @Test
        @DisplayName("Test multiply")
        public void testMultiply1And2() throws Exception {
            assertEquals("2", CalculatorService.calculate("mult", new int[] { 1, 2 }));
        }
    }

    @Nested
    @DisplayName("Test Division")
    class TestDivision {
        @Test
        @DisplayName("Test multiply")
        public void testDivision() throws Exception {
            assertEquals("5", CalculatorService.calculate("div", new int[] { 10, 2 }));
            assertEquals("3(1/3)", CalculatorService.calculate("div", new int[] { 10, 3 }));
        }
    }

}
