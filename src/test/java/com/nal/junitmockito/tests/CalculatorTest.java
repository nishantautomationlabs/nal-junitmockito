package com.nal.junitmockito.tests;

import com.nal.junitmockito.sampleclasses.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nishant on 4/11/19.
 */
public class CalculatorTest {

    Calculator calculator = null;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd1() {
        assertEquals(4, calculator.add(2, 3));
    }

    @Test
    public void testAdd2() {
        assertEquals(5, calculator.add(2, 3));
    }

}