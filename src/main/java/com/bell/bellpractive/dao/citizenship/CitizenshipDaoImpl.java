package com.bell.bellpractive.dao.citizenship;

import com.bell.bellpractive.model.Citizenship;
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
public class CitizenshipDaoImpl implements CitizenshipDao {
    private final EntityManager entityManager;

    @Autowired
    public CitizenshipDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Citizenship> allCitizenship() {
        TypedQuery<Citizenship> typedQuery = entityManager.createQuery("SELECT c FROM Citizenship c", Citizenship.class);
        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Citizenship getCode(String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Citizenship> criteriaQuery = criteriaBuilder.createQuery(Citizenship.class);
        Root<Citizenship> root = criteriaQuery.from(Citizenship.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("code"), code));
        TypedQuery<Citizenship> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }
}
