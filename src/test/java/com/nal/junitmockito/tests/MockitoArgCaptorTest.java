package com.nal.junitmockito.tests;

import com.nal.junitmockito.InventorySystem.InventoryDao;
import com.nal.junitmockito.InventorySystem.InventoryService;
import com.nal.junitmockito.InventorySystem.Product;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by nishant on 6/11/19.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoArgCaptorTest {

    @InjectMocks
    InventoryService inventoryService;

    @Mock
    public InventoryDao inventoryDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        inventoryService = new InventoryService(inventoryDao); //mocked object is used in the test itself. Inject mock is not required
    }

    @Test
    public void testArgumentCaptor() {
        Product defaultProduct = new Product(789, "ABC");
        when(inventoryDao.getProduct(anyInt())).thenReturn(defaultProduct);
        final ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        Product productReturned = inventoryService.getProduct(123);

        Assert.assertEquals(defaultProduct, productReturned);

        verify(inventoryDao).getProduct(captor.capture());

        assertThat(captor.getValue(), is(equalTo(124))); //hamcrest used


    }
}
