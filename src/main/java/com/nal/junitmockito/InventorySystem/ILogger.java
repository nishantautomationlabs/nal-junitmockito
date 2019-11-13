package com.nal.junitmockito.InventorySystem;

/**
 * Created by nishant on 6/11/19.
 */
public interface ILogger {

    void logSuccess(String message);

    void logError(String message);

    void logFailure(String message);


}
