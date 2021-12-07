package it;

import application.service.AddService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestAdd {

    @Test
    @DisplayName("Test 1+1=2")
    public void test1Plus1Equals2() {
        assertEquals(2, AddService.add(new int[] { 1, 1 }));
    }

    @Test
    @DisplayName("Test 1+2+3=6")
    public void test1Plus2Plus3Equals6() {
        assertEquals(6, AddService.add(new int[] { 1, 2, 3 }));
    }

}
