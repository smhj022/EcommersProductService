package com.smhj.ProductService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTest {

    @Test
    void testOnePlusOneIsTwo(){

        int i = 1 + 1; // Arrange + Act

        //Assert -> Checking against the expected value
        //assert i == 3;
        assertEquals(2,i, "1 + 1 should be equal to 2");


    }
}

/*

Test case is nothing but a method that tests a particular functionality
across the expected value.

3A

Arrange
Act
Assert


In one test case we can have multiple assert statements and test case will pass if and only if
all the asset statements will pass

In some of the test cases we might need to check if the function is throwing an exception or not

 */