package com.nal.junitmockito;

import com.nal.junitmockito.sampleclasses.Calculator;

/**
 * Created by nishant on 4/11/19.
 */
public class Main {

    public static void main(String[] args)
    {
//        Calculator calculator = new Calculator();
//        int result = calculator.add(2,3);
//        System.out.println(result);

        ParentClass parentClass = new ChildClass(22);
        ChildClass childClass = null;
        if(parentClass instanceof ChildClass)
            childClass = (ChildClass) parentClass;

        Class tClass = parentClass.getClass();
        Class tClass1 = parentClass.getClass().getSuperclass();
        System.out.println(tClass);
        System.out.println(tClass1);

        System.out.println(childClass.value);
        childClass.value = 66;
        parentClass.upperPrint();
//        parentClass.print();
        parentClass.parentOnlyMethod();
//        parentClass.childOnlyMethod();

    }
}
