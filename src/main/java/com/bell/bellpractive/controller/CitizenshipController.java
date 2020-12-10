package com.bell.bellpractive.controller;


import com.bell.bellpractive.service.citizenship.CitizenshipService;
import com.bell.bellpractive.view.CitizenshipView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Класс контроллер для работы с гражданством
 */
@Api(value = "CitizenshipDirectory", description = "Справочник гражданств различных стран")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class CitizenshipController {
    private final CitizenshipService citizenshipService;

    public CitizenshipController(CitizenshipService citizenshipService) {
        this.citizenshipService = citizenshipService;
    }

    /**
     * Получение списка с гражданствами стран
     * @return список гражданств
     */
    @ApiOperation(value = "Получить список с гражданством", httpMethod = "GET")
    @GetMapping("/api/countries")
    public List<CitizenshipView> getListCitizenship(){
        return citizenshipService.listCitizenship();
    }
}
