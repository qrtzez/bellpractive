package com.bell.bellpractive.service.office;

import com.bell.bellpractive.view.OfficeListView;
import com.bell.bellpractive.view.OfficeSaveView;
import com.bell.bellpractive.view.OfficeUpdateView;
import com.bell.bellpractive.view.OfficeView;

import java.util.List;

/**
 * Сервисный класс для работы с офисами
 */
public interface OfficeService {
    /**
     * Получение списка с DTO-офисами по фильтру
     * @param officeView фильтр-DTO
     * @return список с DTO-офисами
     */
    List<OfficeListView> listOffice(OfficeView officeView);

    /**
     * Получение DTO офиса по идентификатору(id)
     * @param id идентификатор
     * @return DTO-офис
     */
    OfficeView getOfficeById(Long id);

    /**
     * Сохранение офиса
     * @param officeSaveView сохраняемый офис
     */
    void save(OfficeSaveView officeSaveView);

    /**
     * Обновление офиса
     * @param officeView обновляемый офис
     */
    void update(OfficeUpdateView officeView);
}
