package com.example.springframwork.service;


import com.example.springframwork.dao.User;
import com.example.springframwork.dao.UserDao;
import com.example.springframwork.exception.NotNullParameterException;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserDao userDao;


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void add(User user) {
        checkEmptyValue(user);
        userDao.add(user);
    }

    public void checkEmptyValue(User user) {
        // 이렇게 해야하나?
        if (user.getEmail().equals("") || user.getName().equals("")) {
            throw new NotNullParameterException();
        }
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getByOneUser(int id) throws EmptyResultDataAccessException {
        User user = userDao.get(id);
        return user;
    }

    public void userUpdate(User user) {
        User modifiedUser = validateEmptyParameter(user);
        userDao.update(modifiedUser);
    }

    private User validateEmptyParameter(User user) {
        User defaultUser = this.getByOneUser(user.getId());
        // 이렇게 해야하나?
        if (user.getEmail() == null || user.getEmail().equals("")) {
            user.setEmail(defaultUser.getEmail());
        } else if (user.getName() == null || user.getName().equals("")) {
            user.setName(defaultUser.getName());
        }
        return user;
    }
}
