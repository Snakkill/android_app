package com.example.firstapp;

import junit.framework.TestCase;

import org.junit.Test;

public class CalculatorTest extends TestCase {


   public void testAdd(){
        int expected =30;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

}