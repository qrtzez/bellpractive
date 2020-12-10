package com.bell.bellpractive.dao.organization;

import com.bell.bellpractive.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    private final EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> list(Organization organization) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> root = criteriaQuery.from(Organization.class);
        List<Predicate> predicates = new ArrayList<>();
        if(organization != null) {
            predicates.add(criteriaBuilder.equal(root.get("name"), organization.getName()));
            predicates.add(criteriaBuilder.equal(root.get("inn"), organization.getInn()));
            predicates.add(criteriaBuilder.equal(root.get("isActive"), organization.getIsActive()));
            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[]{})));
        }
        TypedQuery<Organization> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getById(Long id) {
        return entityManager.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Organization organization) {
        Organization updateOrganization = entityManager.find(Organization.class, organization.getId());
        updateOrganization.setName(organization.getName());
        updateOrganization.setFullName(organization.getFullName());
        updateOrganization.setInn(organization.getInn());
        updateOrganization.setKpp(organization.getKpp());
        updateOrganization.setAddress(organization.getAddress());
        updateOrganization.setPhone(organization.getPhone());
        updateOrganization.setIsActive(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        entityManager.persist(organization);
    }
}
