package com.nal.junitmockito.sampleclasses;

import com.nal.junitmockito.sampleclasses.CalculatorService;
import com.nal.junitmockito.util.Util;

/**
 * Created by nishant on 4/11/19.
 */
public class ServiceDependentCalculator {

    CalculatorService calculatorService;

//    public ServiceDependentCalculator(CalculatorService calculatorService) {
//        System.out.println("ServiceDependentCalculator constructor called with calculatorService");
//        this.calculatorService = calculatorService;
//    }

    public int multiply(Integer i, Integer j)
    {
        if(i == null || j == null)
            throw new IllegalArgumentException("Please pass correct integer values");

        int result = 0;
        for(int k = 0; k<j; k++) {
            result = calculatorService.add(result, i);
        }
        Util.sendEmail("dummy01@gmail.com");
        return result;
    }

    public void print(String str)
    {
        System.out.println(str);
    }

    public boolean check(Integer integer)
    {
        return true;
    }
}
