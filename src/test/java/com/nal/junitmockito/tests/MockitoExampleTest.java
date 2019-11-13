package com.nal.junitmockito.tests;

import com.nal.junitmockito.sampleclasses.CalculatorService;
import com.nal.junitmockito.sampleclasses.ServiceDependentCalculator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by nishant on 4/11/19.
 */
//@RunWith(MockitoJUnitRunner.class)
public class MockitoExampleTest {

    @InjectMocks
    ServiceDependentCalculator serviceDependentCalculator;
//    CalculatorService calculatorService = Mockito.mock(CalculatorService.class);

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @Mock
    CalculatorService calculatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
//        serviceDependentCalculator = new ServiceDependentCalculator(calculatorService); //mocked object is used in the test itself. Inject mock is not required
    }

    @Test
    public void testMultiply() throws Exception {
        for (int k = 0; k < 4; k++) {
            when(calculatorService.add((3 * k), 3)).thenReturn((3 * k) + 3);
        }
        assertEquals(12, serviceDependentCalculator.multiply(3, 4));

        verify(calculatorService).add(0, 3);
        verify(calculatorService).add(3, 3);
        verify(calculatorService).add(6, 3);
        verify(calculatorService).add(9, 3);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void testException() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Please pass correct integer values");
        serviceDependentCalculator.multiply(null, 4);
    }

//    @Test(expected = NumberFormatException.class)
    @Test
    public void testRunTimeException() {
        when(calculatorService.add(anyInt(), anyInt())).thenThrow(NumberFormatException.class);
        exceptionRule.expect(NumberFormatException.class);
//        exceptionRule.expectMessage("For input string");
        serviceDependentCalculator.multiply(3, 4);
    }

}