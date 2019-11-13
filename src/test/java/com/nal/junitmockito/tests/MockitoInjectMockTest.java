package com.nal.junitmockito.tests;

import com.nal.junitmockito.InventorySystem.ILogger;
import com.nal.junitmockito.InventorySystem.InventoryDao;
import com.nal.junitmockito.InventorySystem.InventoryService;
import com.nal.junitmockito.InventorySystem.Product;
import com.nal.junitmockito.sampleclasses.CalculatorService;
import com.nal.junitmockito.sampleclasses.ServiceDependentCalculator;
import org.hamcrest.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nishant on 4/11/19.
 */
//@RunWith(MockitoJUnitRunner.class)
public class MockitoInjectMockTest {

    /*
    Constructor based injection
    Field based injection
    Setter based injection

    Injectmock does not work with inner class, static inner classes, abstract classes or interfaces
    and the fields that are being injected cant be final or static
    * */

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    InventoryService inventoryService;     //Constructor based injection

    @Mock
    InventoryDao inventoryDao;

    @Mock(name = "successLogger")       //Field based injection
    ILogger logger1;

    @Mock(name = "errorLogger")         //Setter based injection
    ILogger logger2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInjectMocks() throws Exception {
        Product defaultProduct = new Product(789, "ABC");
        when(inventoryDao.getProduct(124)).thenReturn(defaultProduct);

        Product productReturned = inventoryService.getProduct(123);

        assertThat(productReturned, is(equalTo(defaultProduct)));

        verify(logger1).logSuccess(anyString());
        verify(logger2).logError(anyString());

    }
}