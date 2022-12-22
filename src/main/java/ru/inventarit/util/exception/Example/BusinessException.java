package ru.inventarit.util.exception.Example;

public class BusinessException extends Exception{
    public BusinessException(String message) {
        super(message);
        //System.out.println(message);
    }
}