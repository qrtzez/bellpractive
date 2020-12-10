package com.bell.bellpractive.dao.user;

import com.bell.bellpractive.model.User;

import java.util.List;
import java.util.Map;

/**
 * DAO при работе с сотрудниками
 */
public interface UserDao {
    /**
     *Получить сотрудника с применением фильтра
     * @param user фильтр
     * @return список сотрудников
     */
    List<User> list(User user);

    /**
     *Получить сотрудника по идентификатору (Id)
     * @param id идентификатор
     * @return сотрудник
     */
    User getById(Long id);

    /**
     * Обновить данные о сотруднике
     * @param user обновляемый сотрудник
     */
    void update(User user);

    /**
     * Сохранить сотрудника
     * @param user сохраняемый сотрудник
     */
    void save(User user);
}
