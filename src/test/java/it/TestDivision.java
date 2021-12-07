package it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.service.DivisionService;

public class TestDivision {

    @Test
    @DisplayName("test 2/1 = 2")
    public void test2DividedBy1Equals2() {
        assertEquals(2, DivisionService.divide(new int[] { 2, 1 }));
    }

    @Test
    @DisplayName("test 3/2 = 1 (1/2)")
    public void test3DividedBy2EqualsMixedFraction() {
        assertEquals("1 (1/2)", DivisionService.divide(new int[] { 3, 2 }));
    }

}
