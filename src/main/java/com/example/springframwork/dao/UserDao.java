package com.example.springframwork.dao;

import com.example.springframwork.dto.User;

import java.util.List;

public interface UserDao {
    void add(final User user);
//    void setDataSource(DataSource dataSource);
    User get(int id);
    int getCount();
    void deleteAll();
    List<User> getAll();
    void update(User user);
}
