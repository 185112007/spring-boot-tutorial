package com.gafur.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // If number is divisible by 3, print Fizz
    @DisplayName("Divisible by Three")
    @Order(1)
    @Test
    void testForDivisibleByThree(){
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    // If number is divisible by 5, print Buzz
    @DisplayName("Divisible by Five")
    @Order(2)
    @Test
    void testForDivisibleByFive(){
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    // If number is divisible by 3 and 5, print FizzBuzz
    @DisplayName("Divisible by Three and Five")
    @Order(3)
    @Test
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    // If number is NOT divisible by 3 or 5, then print the number
    @DisplayName("Not Divisible by Three or Five")
    @Order(4)
    @Test
    void testForNotDivisibleByThreeOrFive(){
        String expected = "1";

        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }
}
