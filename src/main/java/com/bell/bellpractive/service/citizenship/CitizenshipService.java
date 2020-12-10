package com.bell.bellpractive.service.citizenship;

import com.bell.bellpractive.view.CitizenshipView;

import java.util.List;

/**
 * Сервисный класс для работы с гражданством
 */
public interface CitizenshipService {
    /**
     * Получение списка гражданств различных стран
     * @return список DTO-гражданств
     */
    List<CitizenshipView> listCitizenship();
}
