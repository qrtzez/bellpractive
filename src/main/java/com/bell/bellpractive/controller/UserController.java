package com.bell.bellpractive.controller;

import com.bell.bellpractive.service.user.UserService;
import com.bell.bellpractive.view.UserListView;
import com.bell.bellpractive.view.UserSaveView;
import com.bell.bellpractive.view.UserUpdateView;
import com.bell.bellpractive.view.UserView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Класс контроллер для работы с сотрудником
 */
@Api(value = "UserController", description = "Управление информацией о сотрудниках")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получение сотрудника по идентификатору
     * @param id идентификатор
     * @return Сотрудник
     */
    @ApiOperation(value = "Получить сотрудника по Id", httpMethod = "GET")
    @GetMapping("/{id}")
    public UserView getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * Получение списка сотрудников с применением фильтра
     * @param userView фильтр
     * @return Список сотрудников, попадающих под заданный фильтр
     */
    @ApiOperation(value = "Получить сотрудника с использованием фильтра", httpMethod = "POST")
    @PostMapping("/list")
    public List<UserListView> list(@RequestBody UserView userView) {
        return userService.listUser(userView);
    }

    /**
     * Обновление данных сотрудника
     * @param userUpdateView обновляемый сотрудинк
     * @return обновленные данные сотрудника
     */
    @ApiOperation(value = "Обновить данные о сотруднике", httpMethod = "POST")
    @PostMapping("/update")
    public UserUpdateView update(@RequestBody UserUpdateView userUpdateView) {
        userService.update(userUpdateView);
        return userUpdateView;
    }

    /**
     * Сохранение сотрудника
     * @param userSaveView сохраняемый сотрудник
     * @return сохраненные данные сотрудника
     */
    @ApiOperation(value = "Сохранить данные о сотруднике", httpMethod = "POST")
    @PostMapping("/save")
    public UserSaveView save(@RequestBody UserSaveView userSaveView) {
        userService.save(userSaveView);
        return userSaveView;
    }
}
