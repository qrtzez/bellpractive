package com.bell.bellpractive.dao.typeDocument;


import com.bell.bellpractive.model.TypeDocument;

import java.util.List;

public interface TypeDocumentDao {
    TypeDocument getCode(String code);

    List<TypeDocument> allTypeDocument();
}
