package com.bell.bellpractive.dao.user;

import com.bell.bellpractive.model.User;

import java.util.List;

public interface UserDao {
    List<User> list();

    User getById(Long id);

    void update(User user);

    void save(User user);

    List<User> allUser();
}
