package com.nal.junitmockito.sampleclasses;

/**
 * Created by nishant on 5/11/19.
 */
public interface MyInterface {

    int abstractInterfaceMethod();

    default int defaultInterfaceMethod() {
        System.out.println("defaultInterfaceMethod");
        return 21;
    }

    static int staticInterfaceMethod() {
        System.out.println("staticInterfaceMethod");
        return 22;
    }

}
