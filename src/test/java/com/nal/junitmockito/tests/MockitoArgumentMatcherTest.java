package com.nal.junitmockito.tests;

import com.nal.junitmockito.sampleclasses.CalculatorService;
import com.nal.junitmockito.sampleclasses.ServiceDependentCalculator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by nishant on 4/11/19.
 */
public class MockitoArgumentMatcherTest {

    @InjectMocks
    ServiceDependentCalculator serviceBasedCalculator;

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @Mock
    CalculatorService calculatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
//        serviceBasedCalculator = new ServiceDependentCalculator(calculatorService); //mocked object is used in the test itself. Inject mock is not required
    }

    @Test
    public void testMultiply() throws Exception {
        when(calculatorService.add(anyInt(), anyInt())).thenReturn(3).thenReturn(6).thenReturn(9).thenReturn(12);
        assertEquals(12, serviceBasedCalculator.multiply(3, 4));

        verify(calculatorService, times(4)).add(anyInt(), anyInt());
        verify(calculatorService).add(0, 3);
        verify(calculatorService).add(eq(3), eq(3)); //argument matcher
        verify(calculatorService).add(argThat(arg1 -> arg1.equals(6)), argThat(arg1 -> arg1.equals(3))); //custom matcher using lambda
        verify(calculatorService).add(9, 3);
//        Mockito.verify(calculatorService).add(anyInt(), anyInt());
    }

    @Test
    public void testCustomImplementedArgMatcher()
    {
        ServiceDependentCalculator serviceDependentCalculator = mock(ServiceDependentCalculator.class);
        serviceDependentCalculator.check(11);
        verify(serviceDependentCalculator).check(argThat(new MyArgMatcher()));
    }

    @Test
    public void testCustomImplementedArgMatcher2()
    {
        ServiceDependentCalculator serviceDependentCalculator = mock(ServiceDependentCalculator.class);
        when(serviceDependentCalculator.check(argThat(new MyArgMatcher()))).thenReturn(true);
        assertTrue(serviceDependentCalculator.check(11));
        assertFalse(serviceDependentCalculator.check(-11));
    }

    @Test
    public void testCustomArgMatcherImplementedUsingLambda()
    {
        ServiceDependentCalculator serviceDependentCalculator = mock(ServiceDependentCalculator.class);
        when(serviceDependentCalculator.check(argThat(integer -> integer != null && integer > 0))).thenReturn(true);
        assertTrue(serviceDependentCalculator.check(11));
        assertFalse(serviceDependentCalculator.check(-11));
    }


    public static class MyArgMatcher implements ArgumentMatcher<Integer>{
        Integer integer;

        @Override
        public boolean matches(Integer integer) {
            this.integer = integer;
            boolean result = (integer != null && integer >= 0);
            return result;
        }

        @Override
        public String toString() {
             return String.format("%d must be positive integer", integer);
        }
    }
}