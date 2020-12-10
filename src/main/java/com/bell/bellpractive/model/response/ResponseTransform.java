package com.bell.bellpractive.model.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collections;

/**
 * Класс-обработчик ответов
 */
@ControllerAdvice
public class ResponseTransform implements ResponseBodyAdvice<Object> {

    /**
     * Поддержка
     * @param methodParameter параметры метода
     * @param aClass класс
     * @return логическое выражение
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
       return  !methodParameter.getParameterType().getSimpleName().equals("ResponseEntity");
    }

    /**
     * Обработка данных перед записью
     * @param o информация, поступающая из контроллера
     * @param methodParameter параметры метода
     * @param mediaType тип данных
     * @param aClass класс
     * @param serverHttpRequest HTTP запрос
     * @param serverHttpResponse HTTP ответ
     * @return обернутые обработанные данные для дальнейшей записи в тело ответа
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getMethod() != null) {
            if (methodParameter.getMethod().getName().startsWith("save")
                    || methodParameter.getMethod().getName().startsWith("update")) {
                return Collections.singletonMap("result", "success");
            } else return new DataObject(o);
        }else{
        return o;
        }
    }
}
