package com.example.springframwork.dao;

import com.example.springframwork.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
// Dao는 데이터를 어떻게 가져오고 조작할지를 다루는 곳이지 비지니스 로직을 두는 곳이 아니다.
public class UserDaoJdbc implements UserDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update("INSERT toby2.user(name, email) VALUES(?,?)",user.getName(),user.getEmail());
    }


    @Override
    public User get(int id) {
        return jdbcTemplate.queryForObject("SELECT id,name,email FROM toby2.user where id =?", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName((rs.getString("name")));
            user.setEmail(rs.getString("email"));
            return user;
        },id);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM toby2.user");
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM toby2.user ORDER BY id", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }
    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE toby2.user set name=?, email=? where id = ?",
                user.getName(),user.getEmail(),user.getId());
    }
}
