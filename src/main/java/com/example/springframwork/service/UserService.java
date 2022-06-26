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
        checkNullValue(user);
        userDao.add(user);
    }

    public void checkNullValue(User user) {
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
        // 여기서 업데이트를 하는데, email만 들어왔을 경우에는 업데이트는 email만
        //
        User modifiedUser = validateEmptyParameter(user);
        userDao.update(modifiedUser);
    }

    private User validateEmptyParameter(User user) {
        User defaultUser = this.getByOneUser(user.getId());
        if (user.getEmail() == null || user.getEmail().equals("")) {
            user.setEmail(defaultUser.getEmail());
        } else if (user.getName() == null || user.getName().equals("")) {
            user.setName(defaultUser.getName());
        }
        return user;
    }
}
