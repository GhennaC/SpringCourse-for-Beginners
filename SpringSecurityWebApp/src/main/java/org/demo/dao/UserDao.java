package org.demo.dao;

import org.demo.entity.User;

public interface UserDao {
    User findByUserName(String userName);

    void save(User user);

}
