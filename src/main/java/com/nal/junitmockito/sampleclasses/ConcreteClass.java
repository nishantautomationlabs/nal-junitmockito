package com.nal.junitmockito.sampleclasses;

/**
 * Created by nishant on 5/11/19.
 */
public class ConcreteClass {


    public int instanceMethod() {
        System.out.println("instanceMethod");
        return 1;
    }

    public final int finalMethod() {
        System.out.println("finalMethod");
        return 2;
    }

    public static int staticMethod() {
        System.out.println("staticMethod");
        return 3;
    }

    private int privateMethod() {
        System.out.println("privateMethod");
        return 4;
    }
}
