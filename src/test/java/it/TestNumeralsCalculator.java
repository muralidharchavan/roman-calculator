package it;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import application.service.ConverterInterface;
import application.service.CalculatorService;

public class TestNumeralsCalculator {

    @Nested
    @DisplayName("Test Additions")
    class TestAddition {

        @Test
        @DisplayName("Test valid additions")
        public void testValidAdditions() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("I")).thenReturn(1);
            when(mockService.toNumeral("2")).thenReturn("II");
            assertEquals("II", numeralCalculator.calculate("add", "I,I"));

            when(mockService.toNumber("III")).thenReturn(3);
            when(mockService.toNumber("IV")).thenReturn(4);
            when(mockService.toNumber("V")).thenReturn(5);
            when(mockService.toNumeral("12")).thenReturn("XII");
            assertEquals("XII", numeralCalculator.calculate("add", "III,IV,V"));
        }

        @Test
        @DisplayName("Test invalidResult ")
        public void testInvalidResult() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("MMM")).thenReturn(3000);
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> numeralCalculator.calculate("add", "MMM,MMM"));

            assertTrue(thrown.getMessage().contains("Not Implemented"));
        }

    }

    @Nested
    @DisplayName("Test Subtractions")
    class TestSubtraction {

        @Test
        @DisplayName("Test valid subtractions")
        public void testValidSubtractions() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("II")).thenReturn(2);
            when(mockService.toNumber("III")).thenReturn(3);
            when(mockService.toNumeral("1")).thenReturn("I");
            assertEquals("I", numeralCalculator.calculate("sub", "III,II"));

            when(mockService.toNumber("M")).thenReturn(1000);
            when(mockService.toNumber("D")).thenReturn(500);
            when(mockService.toNumber("C")).thenReturn(100);
            when(mockService.toNumber("L")).thenReturn(50);
            when(mockService.toNumber("X")).thenReturn(10);
            when(mockService.toNumber("V")).thenReturn(5);
            when(mockService.toNumber("I")).thenReturn(1);
            when(mockService.toNumeral("334")).thenReturn("CCCXXXIV");
            assertEquals("CCCXXXIV", numeralCalculator.calculate("sub", "M,D, C, L, X, V, I"));
        }

        @Test
        @DisplayName("Test invalid Subtraction ")
        public void testInvalidSubtraction() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("II")).thenReturn(2);
            when(mockService.toNumber("I")).thenReturn(1);
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> numeralCalculator.calculate("sub", "I,II"));

            assertTrue(thrown.getMessage().contains("Not Implemented"));
        }

        @Test
        @DisplayName("Test nulla ")
        public void testNulla() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("II")).thenReturn(2);
            when(mockService.toNumeral("0")).thenReturn("nulla");
            assertEquals("nulla", numeralCalculator.calculate("sub", "II,II"));
        }

    }

    @Nested
    @DisplayName("Test Multiplications")
    class TestMultiplication {
        @Test
        @DisplayName("Test valid multiplications")
        public void testValidMultiplications() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("III")).thenReturn(3);
            when(mockService.toNumber("V")).thenReturn(5);
            when(mockService.toNumeral("15")).thenReturn("XV");
            assertEquals("XV", numeralCalculator.calculate("mult", "III,V"));

            when(mockService.toNumber("II")).thenReturn(2);
            when(mockService.toNumber("III")).thenReturn(3);
            when(mockService.toNumber("IV")).thenReturn(4);
            when(mockService.toNumeral("24")).thenReturn("XXIV");
            assertEquals("XXIV", numeralCalculator.calculate("mult", "II,III,IV"));
        }

    }

    @Nested
    @DisplayName("Test Division")
    class TestDivision {
        @Test
        @DisplayName("Test valid division")
        public void testValidDivisions() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("VI")).thenReturn(6);
            when(mockService.toNumber("III")).thenReturn(3);
            when(mockService.toNumeral("2")).thenReturn("II");
            assertEquals("II", numeralCalculator.calculate("div", "VI,III"));

            when(mockService.toNumber("XIX")).thenReturn(19);
            when(mockService.toNumber("III")).thenReturn(3);
            when(mockService.toNumber("II")).thenReturn(2);
            when(mockService.toNumeral("3")).thenReturn("III");
            when(mockService.toNumeral("1")).thenReturn("I");
            when(mockService.toNumeral("6")).thenReturn("VI");

            assertEquals("III (I/VI)", numeralCalculator.calculate("div", "XIX,III,II"));
        }

    }

    @Nested
    @DisplayName("Test Invalid Operations")
    class TestInvalidOperations {

        @Test
        @DisplayName("Test invalid operations name")
        public void testValidAdditions() throws Exception {
            ConverterInterface mockService = mock(ConverterInterface.class);
            CalculatorService numeralCalculator = new CalculatorService(mockService);

            when(mockService.toNumber("I")).thenReturn(1);
            when(mockService.toNumeral("2")).thenReturn("II");

            Exception thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> numeralCalculator.calculate("addition", "I,I"));

            assertTrue(thrown.getMessage().contains("Invalid operation"));

        }

    }

}
