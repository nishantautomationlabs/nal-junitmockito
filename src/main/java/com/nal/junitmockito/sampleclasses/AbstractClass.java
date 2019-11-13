package com.nal.junitmockito.sampleclasses;

/**
 * Created by nishant on 5/11/19.
 */
public abstract class AbstractClass {

    public int concreteMethod()
    {
        System.out.println("This is a concrete method inside abstract class");
        return 18;
    }

    public abstract int abstractMethod();
}
