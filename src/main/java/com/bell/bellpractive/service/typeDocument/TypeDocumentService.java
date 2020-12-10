package com.bell.bellpractive.service.typeDocument;

import com.bell.bellpractive.view.TypeDocumentView;

import java.util.List;

/**
 * Сервисный класс для работы с типом документа
 */
public interface TypeDocumentService {
    /**
     * Получение списка всех документов
     * @return Список DTO-типов документа
     */
    List<TypeDocumentView> listTypeDocument();
}
