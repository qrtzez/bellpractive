package com.bell.bellpractive.dao.office;

import com.bell.bellpractive.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {
    private EntityManager entityManager;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> list(Office office) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> root = criteriaQuery.from(Office.class);
        List<Predicate> predicates = new LinkedList<>();

            predicates.add(criteriaBuilder.equal(root.get("orgId"), office.getOrgId()));
            if(office.getName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), office.getName()));
            }
            if(office.getPhone() != null) {
                predicates.add(criteriaBuilder.equal(root.get("phone"), office.getPhone()));
            }
            if(office.getIsActive() != null) {
                predicates.add(criteriaBuilder.equal(root.get("isActive"), office.getIsActive()));
            }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<Office> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office getOfficeById(Long id) {
        return entityManager.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Office office) {
        Office officeUpdate = entityManager.find(Office.class, office.getId());
        officeUpdate.setName(office.getName());
        officeUpdate.setAddress(office.getAddress());
        officeUpdate.setPhone(office.getPhone());
        officeUpdate.setIsActive(office.getIsActive());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        entityManager.persist(office);
    }
}
