package com.bell.bellpractive.dao.organization;

import com.bell.bellpractive.model.Organization;

import java.util.List;

/**
 * DAO для работы с организациями
 */
public interface OrganizationDao {
    /**
     * Получение списка с организациями по фильтру
     * @param organization фильтр
     * @return список организаций
     */
    List<Organization> list(Organization organization);

    /**
     * Получение организаци по идентификатору
     * @param id идентификатор
     * @return организация
     */
    Organization getById(Long id);

    /**
     * Обновить организацию
     * @param organization обновляемая организация
     */
    void update(Organization organization);

    /**
     * Сохранить организацию
     * @param organization сохраняемая организация
     */
    void save(Organization organization);
}
