package it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import application.service.IConverterService;
import application.service.RomanCalculatorService;

public class TestRomanCalculator {

    @Nested
    @DisplayName("Test Additions")
    class TestAddition {

        @Test
        @DisplayName("Test I+I=II")
        public void testIPlusIEqualsII() {
            IConverterService mockService = mock(IConverterService.class);
            RomanCalculatorService romanCalculator = new RomanCalculatorService(mockService);

            when(mockService.convertToNumber("I")).thenReturn(1);
            when(mockService.convertToRoman("2")).thenReturn("II");
            assertEquals("II", romanCalculator.calculateUsingRomanNumbers("add", "I,I"));
        }

        @Test
        @DisplayName("Test III+IV+V=XII")
        public void testIIIPlusIVPlusVEqualsXII() {
            IConverterService mockService = mock(IConverterService.class);
            RomanCalculatorService romanCalculator = new RomanCalculatorService(mockService);

            when(mockService.convertToNumber("III")).thenReturn(3);
            when(mockService.convertToNumber("IV")).thenReturn(4);
            when(mockService.convertToNumber("V")).thenReturn(5);
            when(mockService.convertToRoman("12")).thenReturn("XII");
            assertEquals("XII", romanCalculator.calculateUsingRomanNumbers("add", "III,IV,V"));
        }
    }

    @Nested
    @DisplayName("Test Subtractions")
    class TestSubtraction {

        @Test
        @DisplayName("Test III-II=I")
        public void testIIIMinuxIIEqualsI() {
            IConverterService mockService = mock(IConverterService.class);
            RomanCalculatorService romanCalculator = new RomanCalculatorService(mockService);

            when(mockService.convertToNumber("II")).thenReturn(2);
            when(mockService.convertToNumber("III")).thenReturn(3);
            when(mockService.convertToRoman("1")).thenReturn("I");
            assertEquals("I", romanCalculator.calculateUsingRomanNumbers("sub", "III,II"));
        }

        @Test
        @DisplayName("Test M-D-C-L-X-V-I=CCCXXXIV")
        public void testBigSubraction() {
            IConverterService mockService = mock(IConverterService.class);
            RomanCalculatorService romanCalculator = new RomanCalculatorService(mockService);

            when(mockService.convertToNumber("M")).thenReturn(1000);
            when(mockService.convertToNumber("D")).thenReturn(500);
            when(mockService.convertToNumber("C")).thenReturn(100);
            when(mockService.convertToNumber("L")).thenReturn(50);
            when(mockService.convertToNumber("X")).thenReturn(10);
            when(mockService.convertToNumber("V")).thenReturn(5);
            when(mockService.convertToNumber("I")).thenReturn(1);
            when(mockService.convertToRoman("334")).thenReturn("CCCXXXIV");
            assertEquals("CCCXXXIV", romanCalculator.calculateUsingRomanNumbers("sub", "M,D, C, L, X, V, I"));
        }
    }
}
