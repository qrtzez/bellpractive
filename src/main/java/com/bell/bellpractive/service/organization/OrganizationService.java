package com.bell.bellpractive.service.organization;

import com.bell.bellpractive.view.OrganizationListView;
import com.bell.bellpractive.view.OrganizationSaveView;
import com.bell.bellpractive.view.OrganizationUpdateView;
import com.bell.bellpractive.view.OrganizationView;

import java.util.List;

/**
 * Сервисный класс для работы с офисами
 */
public interface OrganizationService {
    /**
     * Получение списка DTO организаций по фильтру
     * @param organizationView фильтр
     * @return список DTO-организаций
     */
    List<OrganizationListView> listOrganization(OrganizationView organizationView);

    /**
     * Получение DTO-организации по идентификатору
     * @param id идентификатор
     * @return DTO организация
     */
    OrganizationView getOrganizationById(Long id);

    /**
     * Сохранение организации
     * @param organizationSaveView сохраняемая организация
     */
    void save(OrganizationSaveView organizationSaveView);

    /**
     * Обновление организации
     * @param organizationUpdateView обновляемая организация
     */
    void update(OrganizationUpdateView organizationUpdateView);
}
