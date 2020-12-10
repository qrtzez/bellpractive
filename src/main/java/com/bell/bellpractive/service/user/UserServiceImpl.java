package com.bell.bellpractive.service.user;

import com.bell.bellpractive.dao.user.UserDao;
import com.bell.bellpractive.exception.IncorrectDataException;
import com.bell.bellpractive.exception.NotFoundException;
import com.bell.bellpractive.model.Office;
import com.bell.bellpractive.model.User;
import com.bell.bellpractive.view.UserListView;
import com.bell.bellpractive.view.UserSaveView;
import com.bell.bellpractive.view.UserUpdateView;
import com.bell.bellpractive.view.UserView;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final MapperFactory mapperFactory;

    @Autowired
    public UserServiceImpl(UserDao userDao, MapperFactory mapperFactory) {
        this.userDao = userDao;
        this.mapperFactory = mapperFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserView getUserById(Long id) {
        User user = userDao.getById(id);
        if(user == null){
            throw new NotFoundException("User not found");
        }
               return mapperFactory.getMapperFacade(User.class, UserView.class).map(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<UserListView> listUser(UserView userView) {
        User user = mapperFactory.getMapperFacade().map(userView, User.class);
        List<User> listUser = userDao.list(user);
        if(listUser.size() == 0){
            throw new NotFoundException("The list of user is empty");
        }
        return listUser.stream()
                .map(mapperFactory.getMapperFacade(User.class, UserListView.class)::map)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(UserUpdateView userUpdateView) {
        User user = mapperFactory.getMapperFacade().map(userUpdateView, User.class);
        try {
            userDao.update(user);
        }catch (Exception e){
            throw new IncorrectDataException();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(UserSaveView userSaveView) {
        User user = mapperFactory.getMapperFacade().map(userSaveView, User.class);
        userDao.save(user);
    }
}
