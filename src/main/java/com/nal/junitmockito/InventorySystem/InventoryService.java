package com.nal.junitmockito.InventorySystem;

/**
 * Created by nishant on 5/11/19.
 */
public class InventoryService {

    private InventoryDao inventoryDao;

    private ILogger successLogger;

    private ILogger errorLogger;

    public ILogger getErrorLogger() {
        return errorLogger;
    }

    public void setErrorLogger(ILogger errorLogger) {
        System.out.println("setter for errorLogger called");
        this.errorLogger = errorLogger;
    }

    public InventoryService(InventoryDao inventoryDao) {
        System.out.println("InventoryService constructor called");
        this.inventoryDao = inventoryDao;
    }

    public boolean isProductAvailable(int productId){
        //do some processing
        successLogger.logSuccess(Integer.toString(productId));
        errorLogger.logError(Integer.toString(productId));
        return inventoryDao.isProductAvailable(productId);
    }

    public Product getProduct(int productId){
        successLogger.logSuccess(Integer.toString(productId));
        errorLogger.logError(Integer.toString(productId));
        inventoryDao.print();
        return inventoryDao.getProduct(++productId);
    }


}
