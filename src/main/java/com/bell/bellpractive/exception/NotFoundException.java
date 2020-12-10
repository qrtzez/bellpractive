package com.bell.bellpractive.exception;

/**
 * Класс исключений о не найденных данных
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }

}
