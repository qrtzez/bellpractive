package com.bell.bellpractive.controller;

import com.bell.bellpractive.service.organization.OrganizationService;
import com.bell.bellpractive.view.OrganizationListView;
import com.bell.bellpractive.view.OrganizationSaveView;
import com.bell.bellpractive.view.OrganizationUpdateView;
import com.bell.bellpractive.view.OrganizationView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Класс контроллер для работы с организациями
 */
@Api(value = "OrganizationController",
        description = "Управление информацией организаций")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получение списка организаций с применением фильтра
     * @param organizationView фильтр
     * @return список организаций, попадающих под заданный фильтр
     */
    @ApiOperation(value = "Получить список организаций", httpMethod = "POST")
    @PostMapping("/list")
    public List<OrganizationListView> list(@RequestBody OrganizationView organizationView){
        return organizationService.listOrganization(organizationView);
    }

    /**
     * Получение организации по идентификатору
     * @param id идентификатор
     * @return организация
     */
    @ApiOperation(value = "Получить организацию по Id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationView getOrganizationById(@PathVariable("id") Long id){
        return organizationService.getOrganizationById(id);
    }

    /**
     * Сохранение организации
     * @param organizationSaveView сохраняемая организация
     * @return сохраненные данные организации
     */
    @ApiOperation(value = "Сохранить организацию", httpMethod = "POST")
    @PostMapping("/save")
    public OrganizationSaveView save(@RequestBody OrganizationSaveView organizationSaveView){
        organizationService.save(organizationSaveView);
        return organizationSaveView;
    }

    /**
     * Обновление организации
     * @param organizationUpdateView обновляемая организация
     * @return обновленные данные организации
     */
    @ApiOperation(value = "Обновить данные об организации", httpMethod = "POST")
    @PostMapping("/update")
    public OrganizationUpdateView update(@RequestBody OrganizationUpdateView organizationUpdateView){
        organizationService.update(organizationUpdateView);
        return organizationUpdateView;
    }
}
