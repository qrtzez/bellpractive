package com.bell.bellpractive.controller;

import com.bell.bellpractive.service.office.OfficeService;
import com.bell.bellpractive.view.OfficeListView;
import com.bell.bellpractive.view.OfficeSaveView;
import com.bell.bellpractive.view.OfficeUpdateView;
import com.bell.bellpractive.view.OfficeView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией офисов")
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Получить список офисов", httpMethod = "POST")
    @PostMapping("/list")
    public List<OfficeListView> listOffice(@RequestBody OfficeView officeView){
        return officeService.listOffice(officeView);
    }

    @ApiOperation(value = "Получить офис по Id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeView getOfficeById(@PathVariable("id") Long id){
        return officeService.getOfficeById(id);
    }

    @ApiOperation(value = "Обновить данные об офисе", httpMethod = "POST")
    @PostMapping("/update")
    public OfficeUpdateView update(@RequestBody OfficeUpdateView officeUpdateView){
        officeService.update(officeUpdateView);
        return officeUpdateView;
    }

    @ApiOperation(value = "Сохранить офис", httpMethod = "POST")
    @PostMapping("/save")
    public OfficeSaveView save(@RequestBody OfficeSaveView officeSaveView){
         officeService.save(officeSaveView);
         return officeSaveView;
    }
}
