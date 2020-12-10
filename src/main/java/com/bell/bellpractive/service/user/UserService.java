package com.bell.bellpractive.service.user;

import com.bell.bellpractive.view.UserListView;
import com.bell.bellpractive.view.UserSaveView;
import com.bell.bellpractive.view.UserUpdateView;
import com.bell.bellpractive.view.UserView;

import java.util.List;

/**
 * Сервисный класс для работы с сотрудниками
 */
public interface UserService {
    /**
     * Получение DTO сотрудника по идентификатору
     * @param id идентификатор
     * @return DTO сотрудника
     */
    UserView getUserById(Long id);

    /**
     * Получение списка DTO сотрудников по фильтру
     * @param userView DTO(сотрудник)-фильтр
     * @return список DTO сотрудников
     */
    List<UserListView> listUser(UserView userView);

    /**
     * Обновление сотрудника
     * @param userUpdateView обновляемый сотрудник(DTO)
     */
     void update(UserUpdateView userUpdateView);

    /**
     * Сохранение сотрудника
     * @param userSaveView сохраняемый сотрудник(DTO)
     */
    void save(UserSaveView userSaveView);

}
