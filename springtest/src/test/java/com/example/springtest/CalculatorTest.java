package com.example.springtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

   Calculator calculator;

   @BeforeEach
    void setUp() {
       calculator = new Calculator();
   }

   @DisplayName("tran khac nhu developer")
   @Test
    void testMultiple() {
       Assertions.assertEquals(20, calculator.multiple(2, 10));
       Assertions.assertEquals(25, calculator.multiple(5, 5));

   }

   @Test
    void testDevide() {
       Assertions.assertEquals(2, calculator.divide(10, 5));

   }

}
