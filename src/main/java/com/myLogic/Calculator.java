package com.myLogic;

/**
 * Created by Aleks on 06.03.2016.
 */
public class Calculator {
    private int first;
    private int second;
    private String operation;

    public Calculator(int first, int second,String operation ) {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    public int multi(){
        return first * second;
    }
    public int plus() {
        return first + second;
    }
    public int del() {
        return first / second;
    }
    public int minus () {
        return first - second;
    }
}
