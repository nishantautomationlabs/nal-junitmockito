package com.nal.junitmockito.tests;

import com.nal.junitmockito.InventorySystem.ILogger;
import com.nal.junitmockito.InventorySystem.InventoryDao;
import com.nal.junitmockito.InventorySystem.InventoryService;
import com.nal.junitmockito.InventorySystem.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

/**
 * Created by nishant on 8/11/19.
 */
public class MockitoDoMethodsTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private InventoryDao inventoryDao;

    @Mock(name = "successLogger")       //Field based injection
            ILogger logger1;

    @Mock(name = "errorLogger")         //Setter based injection
            ILogger logger2;

    @InjectMocks
    private InventoryService inventoryService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testDoThrow() {

        Product defaultProduct = new Product(789, "ABC");
        when(inventoryDao.getProduct(124)).thenReturn(defaultProduct);
//        Mockito.when(inventoryDao.print()).thenThrow(RuntimeException.class); //Throws error as when expects a return type
//        Mockito.doThrow(RuntimeException.class).when(inventoryDao).print();
        doThrow(new ArrayIndexOutOfBoundsException()).when(inventoryDao).print();
        exceptionRule.expect(ArrayIndexOutOfBoundsException.class);
        inventoryService.getProduct(123);
    }

    @Test
    public void testDoReturn() {
        Product defaultProduct = new Product(789, "ABC");
        final InventoryService spy = spy(inventoryService);

        doReturn(defaultProduct).when(spy).getProduct(123);

        Product returnValue = spy.getProduct(123);
        Assert.assertEquals(defaultProduct, returnValue);
    }

    @Test
    public void testDoAnswer() {
        Product defaultProduct = new Product(789, "ABC");

//        when(inventoryDao.getProduct(anyInt())).thenReturn(defaultProduct); //Static at compile time

        doAnswer(invocation -> {                                        // more flexible - runtime decision
            Integer id = invocation.getArgument(0, Integer.class);
            return id == 124 ? defaultProduct : null;
        }).when(inventoryDao).getProduct(anyInt());

        Product returnValue = inventoryService.getProduct(123);
        Assert.assertEquals(defaultProduct, returnValue);

        Product returnValue2 = inventoryService.getProduct(234);
        Assert.assertEquals(null, returnValue2);
    }

    @Test
    public void testDoNothing() {

        doNothing()         // on first call do nothing
        .doThrow(new ArrayIndexOutOfBoundsException())    //on second call throw exception
        .when(inventoryDao).print();

        exceptionRule.expect(ArrayIndexOutOfBoundsException.class);
        inventoryService.getProduct(123);
        inventoryService.getProduct(123);
    }

    @Test
    public void testDoCallRealMethod() {
        Product realProduct = new Product(123, "XYZ");
        doCallRealMethod().when(inventoryDao).getProduct(anyInt());

        Product returnValue = inventoryService.getProduct(123);
        Assert.assertEquals(realProduct.getProductId(), 123);
        Assert.assertEquals(realProduct.getProductName(), "XYZ");
    }
}
