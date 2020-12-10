package com.bell.bellpractive.service.typeDocument;

import com.bell.bellpractive.dao.typeDocument.TypeDocumentDao;
import com.bell.bellpractive.exception.NotFoundException;
import com.bell.bellpractive.model.TypeDocument;
import com.bell.bellpractive.view.TypeDocumentView;
import javassist.compiler.NoFieldException;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class TypeDocumentServiceImpl  implements TypeDocumentService{
    private final TypeDocumentDao typeDocumentDao;
    private final MapperFactory mapperFactory;

    @Autowired
    public TypeDocumentServiceImpl(TypeDocumentDao typeDocumentDao, MapperFactory mapperFactory) {
        this.typeDocumentDao = typeDocumentDao;
        this.mapperFactory = mapperFactory;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<TypeDocumentView> listTypeDocument() {
        List<TypeDocument> listTypeDocument = typeDocumentDao.allTypeDocument();
        if(listTypeDocument.size() == 0){
            throw new NotFoundException("The list is empty");
        }
        return mapperFactory.getMapperFacade().mapAsList(listTypeDocument, TypeDocumentView.class);
    }
}
