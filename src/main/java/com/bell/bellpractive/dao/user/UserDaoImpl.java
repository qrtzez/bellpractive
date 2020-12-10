package com.bell.bellpractive.dao.user;

import com.bell.bellpractive.exception.NotFoundException;
import com.bell.bellpractive.model.*;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> list(User user) {
        DocumentUser documentUser = user.getDocumentUser();
        Citizenship citizenship = user.getCitizenship();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        List<Predicate> predicates = new LinkedList<>();
        if(user.getOfficeId() != null){
            predicates.add(criteriaBuilder.equal(root.get("officeId"), user.getOfficeId()));
        }
        if(user.getFirstName() !=null) {
            predicates.add(criteriaBuilder.equal(root.get("firstName"), user.getFirstName()));
        }
        if(user.getSecondName() !=null) {
            predicates.add(criteriaBuilder.equal(root.get("secondName"), user.getSecondName()));
        }
        if(user.getMiddleName() !=null) {
            predicates.add(criteriaBuilder.equal(root.get("middleName"), user.getMiddleName()));
        }
        if(user.getPosition() !=null) {
            predicates.add(criteriaBuilder.equal(root.get("position"), user.getPosition()));
        }
        if(documentUser != null) {
            predicates.add(criteriaBuilder.equal(root.get("documentUser").get("typeDocument").get("code"),
                    documentUser.getTypeDocument().getCode()));
        }
        if(citizenship != null) {
            predicates.add(criteriaBuilder.equal(root.get("citizenship").get("code"), citizenship.getCode()));
        }
        if(predicates.size()==0){
            throw  new NotFoundException("Empty predicate list");
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{})).select(root);
        TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {
            entityManager.merge(user);
        }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
