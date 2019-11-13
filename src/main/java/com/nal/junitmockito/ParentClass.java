package com.nal.junitmockito;

/**
 * Created by nishant on 9/11/19.
 */
public class ParentClass {

    public int value;

    public ParentClass(int value) {
        this.value = value;
    }

    public final void upperPrint() {
        System.out.println(value);
        print();
    }

    protected void print()
    {
        System.out.println("Parent");
        System.out.println(value);
    }

    public void parentOnlyMethod()
    {
        System.out.println("parentOnlyMethod");
    }
}
