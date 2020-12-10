package com.bell.bellpractive.dao.typeDocument;

import com.bell.bellpractive.model.TypeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class TypeDocumentDaoImpl implements TypeDocumentDao {
    private final EntityManager entityManager;

    @Autowired
    public TypeDocumentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDocument getCode(String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TypeDocument> criteriaQuery = criteriaBuilder.createQuery(TypeDocument.class);
        Root<TypeDocument> documentRoot = criteriaQuery.from(TypeDocument.class);
        criteriaQuery.select(documentRoot);
        criteriaQuery.where(criteriaBuilder.equal(documentRoot.get("code"), code));
        TypedQuery<TypeDocument> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TypeDocument> allTypeDocument() {
        TypedQuery<TypeDocument> typeDocumentTypedQuery = entityManager.createQuery("SELECT td FROM TypeDocument td", TypeDocument.class);
        return typeDocumentTypedQuery.getResultList();
    }
}
