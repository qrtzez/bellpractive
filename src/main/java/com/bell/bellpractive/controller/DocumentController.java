package com.bell.bellpractive.controller;

import com.bell.bellpractive.model.TypeDocument;
import com.bell.bellpractive.service.typeDocument.TypeDocumentService;
import com.bell.bellpractive.view.TypeDocumentView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Класс контроллер для работы с документами
 */
@Api(value = "DocumentDirectory", description = "Справочник документов")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class DocumentController {
    private final TypeDocumentService typeDocumentService;

    public DocumentController(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    /**
     * Получение списка документов
     * @return документов
     */
    @ApiOperation(value = "Получить список с документами", httpMethod = "GET")
    @GetMapping("/api/docs")
    public List<TypeDocumentView> getListDocuments(){
        return typeDocumentService.listTypeDocument();
    }
}
