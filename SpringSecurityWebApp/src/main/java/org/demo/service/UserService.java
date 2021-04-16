package org.demo.service;

import org.demo.entity.CrmUser;
import org.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);

    void save(CrmUser crmUser);
}