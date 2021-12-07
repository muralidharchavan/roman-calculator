package it;

import application.service.MultiplyService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMultiply {

    @Test
    @DisplayName("Test 1*2=2")
    public void test1MultipliedBy2Equals2() {
        assertEquals(2, MultiplyService.multiply(new int[] { 1, 2 }));
    }

    @Test
    @DisplayName("Test 1+2+3=6")
    public void test1MultipliedBy2MultipliedBy3Equals6() {
        assertEquals(6, MultiplyService.multiply(new int[] { 1, 2, 3 }));
    }

}
