package it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import application.service.CalculatorService;

public class TestCalculator {

    @Nested
    @DisplayName("Test Addition")
    class TestAddition {
        @Test
        @DisplayName("Test 1+1=2")
        public void test1Plus1Equals2() {
            assertEquals("2", CalculatorService.calculate("add", new int[] { 1, 1 }));
        }

        @Test
        @DisplayName("Test 1+2+3=6")
        public void test1Plus2Plus3Equals6() {
            assertEquals("6", CalculatorService.calculate("add", new int[] { 1, 2, 3 }));
        }
    }

    @Nested
    @DisplayName("Test Subtraction")
    class TestSubtraction {

        @Test
        @DisplayName("Test 2-1=1")
        public void test2Minus1() {
            assertEquals("1", CalculatorService.calculate("sub", new int[] { 2, 1 }));
        }

        @Test
        @DisplayName("Test 4-2-1=1")
        public void test4Minus2Mnus1Equals1() {
            assertEquals("1", CalculatorService.calculate("sub", new int[] { 4, 2, 1 }));
        }

    }

    @Nested
    @DisplayName("Test Multiplication")
    class TestMultiplication {
        @Test
        @DisplayName("Test multiply")
        public void testMultiply1And2() {
            assertEquals("2", CalculatorService.calculate("mult", new int[] { 1, 2 }));
        }

        @Test
        @DisplayName("Test divide")
        public void testDivide2By1() {
            assertEquals("2", CalculatorService.calculate("div", new int[] { 2, 1 }));
        }
    }

    @Nested
    @DisplayName("Test Invalid operation")
    class TestInvalidOperation {
        @Test
        @DisplayName("Test some other operation")
        public void testSomeOtherOperation() {

            Exception thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> CalculatorService.calculate("some", new int[] { 1, 2 }));

            assertTrue(thrown.getMessage().contains("Invalid operation"));
        }
    }

}
