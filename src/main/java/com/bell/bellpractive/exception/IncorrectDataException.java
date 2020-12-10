package com.bell.bellpractive.exception;

/**
 * Класс исключений о некорректных введенных данных
 */
public class IncorrectDataException extends RuntimeException {
    public  IncorrectDataException(){
        super("Incorrect data");
    }
}
