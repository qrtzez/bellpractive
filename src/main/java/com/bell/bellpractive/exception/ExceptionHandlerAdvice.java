package com.bell.bellpractive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс обработчик исключений
 */
@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    /**
     * Обработка исключений типа NotFoundException
     * @param exception выявленное исключение
     * @return обработанную информацию об ошибке
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception){
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("error", exception.getMessage());
        return new ResponseEntity<>(objectMap, HttpStatus.NOT_FOUND);
    }

    /**
     * Обработка исключения типа IncorrectDataException
     * @param exception выявленное исключение
     * @return обработанну информацию об ошибке
     */
    @ExceptionHandler(IncorrectDataException.class)
    public ResponseEntity<Object> handleIncorrectDataException(IncorrectDataException exception){
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("error", exception.getMessage());
        return new ResponseEntity<>(objectMap, HttpStatus.NOT_FOUND);
    }
}
