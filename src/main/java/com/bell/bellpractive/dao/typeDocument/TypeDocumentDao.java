package com.bell.bellpractive.dao.typeDocument;


import com.bell.bellpractive.model.TypeDocument;

import java.util.List;

/**
 * DAO для работы с типом документа
 */
public interface TypeDocumentDao {
    /**
     * Получение типа документа по коду
     * @param code код, по которому ищется тип документа
     * @return тип документа
     */
    TypeDocument getCode(String code);

    /**
     * Получение списка всех типов документов
     * @return список типов документов
     */
    List<TypeDocument> allTypeDocument();
}
