package com.nal.junitmockito;

/**
 * Created by nishant on 9/11/19.
 */
public class ChildClass extends ParentClass {

    public int value;

    public ChildClass(int value) {
        super(33);
        this.value = value;
    }

    protected void print()
    {
        System.out.println("Child");
        System.out.println(value);
    }

    public void childOnlyMethod()
    {
        System.out.println("childOnlyMethod");
    }

}
