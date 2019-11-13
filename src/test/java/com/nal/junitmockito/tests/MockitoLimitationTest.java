package com.nal.junitmockito.tests;

import com.nal.junitmockito.sampleclasses.CalculatorService;
import com.nal.junitmockito.sampleclasses.AbstractClass;
import com.nal.junitmockito.sampleclasses.ConcreteClass;
import com.nal.junitmockito.sampleclasses.FinalClass;
import com.nal.junitmockito.sampleclasses.MyInterface;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nishant on 4/11/19.
 */
public class MockitoLimitationTest {


    //Cant mock final class\method
    //Cant mock static methods
    //Cant mock private methods
    //Cant mock constructors
    //Cant mock equals(), hashcode() method

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Mock
    CalculatorService calculatorService;

    @Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFinalClass() {
        final FinalClass finalClass = mock(FinalClass.class);
        when(finalClass.print()).thenReturn(false);
        exceptionRule.expect(MockitoException.class);
    }

    @Test
    public void testAbstractClass() {
        AbstractClass abstractClass = mock(AbstractClass.class);
        when(abstractClass.concreteMethod()).thenReturn(32);
        assertEquals(32, abstractClass.concreteMethod());

        when(abstractClass.abstractMethod()).thenReturn(24);
        assertEquals(24, abstractClass.abstractMethod());

    }

    @Test
    public void testInstanceMethod() {
        ConcreteClass concreteClass = mock(ConcreteClass.class);
        when(concreteClass.instanceMethod()).thenReturn(11);
        assertEquals(11, concreteClass.instanceMethod());
    }

    @Test
    public void testFinalMethod() {
        ConcreteClass concreteClass = mock(ConcreteClass.class);
        when(concreteClass.finalMethod()).thenReturn(12);
    }

//    @Test
//    public void testPrivateMethod() {
//        ConcreteClass concreteClass = mock(ConcreteClass.class);
//        when(concreteClass.privateMethod()).thenReturn(14);
//    }

    @Test
    public void testStaticMethod() {
        ConcreteClass concreteClass = mock(ConcreteClass.class);
        when(concreteClass.staticMethod()).thenReturn(13);
    }

    @Test
    public void testInterfaceAbstractMethod() {
        MyInterface myInterface = mock(MyInterface.class);
        when(myInterface.abstractInterfaceMethod()).thenReturn(13);
        assertEquals(13, myInterface.abstractInterfaceMethod());
    }

    @Test
    public void testInterfaceDefaultMethod() {
        MyInterface myInterface = mock(MyInterface.class);
        when(myInterface.defaultInterfaceMethod()).thenReturn(21);
        assertEquals(21, myInterface.defaultInterfaceMethod());
        verify(myInterface, Mockito.times(1)).defaultInterfaceMethod();
    }

//    @Test
//    public void testInterfaceStaticMethod() {
//        MyInterface myInterface = mock(MyInterface.class);
//        verify(myInterface).staticInterfaceMethod();
//        when(myInterface.staticInterfaceMethod()).thenReturn(22);
//        assertEquals(22, myInterface.staticInterfaceMethod());
//    }

}