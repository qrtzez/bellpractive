package com.bell.bellpractive.dao.office;

import com.bell.bellpractive.model.Office;

import java.util.List;

/**
 * DAO при работе с офисами
 */
public interface OfficeDao {

    /**
     * Получение списка офисов по фильтру
     * @param office фильтр
     * @return список офисов
     */
    List<Office> list(Office office);

    /**
     * Получение офиса по идентификатору
     * @param id идентификатор
     * @return офис
     */
    Office getOfficeById(Long id);

    /**
     * обновить офис
     * @param office обновляемый офис
     */
    void update(Office office);

    /**
     * сохранить офис
     * @param office сохраняемый офис
     */
    void save(Office office);
}
