package it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.service.SubtractService;

public class TestSubtract {

    @Test
    @DisplayName("Test 2-1=1")
    public void test2Minus1() {
        assertEquals(1, SubtractService.subtract(new int[] { 2, 1 }));
    }

    @Test
    @DisplayName("Test 4-2-1=1")
    public void test4Minus2Mnus1Equals1() {
        assertEquals(1, SubtractService.subtract(new int[] { 4, 2, 1 }));
    }

}
