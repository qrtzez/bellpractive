package com.bell.bellpractive.dao.user;

import com.bell.bellpractive.dao.citizenship.CitizenshipDao;
import com.bell.bellpractive.dao.typeDocument.TypeDocumentDao;
import com.bell.bellpractive.model.Citizenship;
import com.bell.bellpractive.model.DocumentUser;
import com.bell.bellpractive.model.TypeDocument;
import com.bell.bellpractive.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager;
    private final CitizenshipDao citizenshipDao;
    private final TypeDocumentDao typeDocumentDao;

    public UserDaoImpl(EntityManager entityManager, CitizenshipDao citizenshipDao, TypeDocumentDao typeDocumentDao) {
        this.entityManager = entityManager;
        this.citizenshipDao = citizenshipDao;
        this.typeDocumentDao = typeDocumentDao;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        User updateUser = entityManager.find(User.class, user.getId());
        if(updateUser != null){
            updateUser.setFirstName(user.getFirstName());
            updateUser.setSecondName(user.getSecondName());
            updateUser.setMiddleName(user.getMiddleName());
            updateUser.setPosition(user.getPosition());
            updateUser.setPhone(user.getPhone());
            updateUser.setIdentified(user.isIdentified());

            DocumentUser userDocumentUser = user.getDocumentUser();
            if(userDocumentUser != null){
                DocumentUser updateDocumentUser = updateUser.getDocumentUser();
                if(updateDocumentUser ==null){
                    updateDocumentUser = new DocumentUser();
                    entityManager.persist(updateDocumentUser);
                }
                TypeDocument typeDocument = userDocumentUser.getTypeDocument();
                if(typeDocument != null){
                    typeDocument = typeDocumentDao.getCode(typeDocument.getCode());
                }
                updateDocumentUser.getTypeDocument().setType(userDocumentUser.getTypeDocument().getType());
                updateDocumentUser.setNumber(userDocumentUser.getNumber());
                updateDocumentUser.setDate(userDocumentUser.getDate());
            }
            Citizenship citizenship = user.getCitizenship();
            citizenship = citizenshipDao.getCode(citizenship.getCode());
            updateUser.setCitizenship(citizenship);
            entityManager.merge(updateUser);
        }
    }

    @Override
    public void save(User user) {

    }

    @Override
    public List<User> allUser() {
        TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
        return typedQuery.getResultList() ;
    }
}
