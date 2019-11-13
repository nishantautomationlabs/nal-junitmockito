package com.nal.junitmockito.InventorySystem;

/**
 * Created by nishant on 5/11/19.
 */
public class InventoryDao {

    private static Product defaultProduct = new Product(123, "XYZ");

    public boolean isProductAvailable(int productId){
        //make db connection and get value;
        return true;
    }

    public Product getProduct(int productId){
        //make db connection and get value;
        return defaultProduct;
    }

    public void print() {
        System.out.printf("Printing");
    }
}
