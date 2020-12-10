package com.bell.bellpractive.dao.citizenship;

import com.bell.bellpractive.model.Citizenship;

import java.util.List;

/**
 * DAO для работы с гражданством
 */
public interface CitizenshipDao {
    /**
     * Получение списка всех видов гражданства из базы данных
     * @return список гражданств
     */
    List<Citizenship> allCitizenship();

    /**
     * Получение вида гражданства по коду
     * @param code код, по которому ищется гражданство
     * @return Гражданство
     */
    Citizenship getCode(String code);
}
