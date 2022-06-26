package com.example.springframwork;


import com.example.springframwork.dao.User;
import com.example.springframwork.dao.UserDao;
import com.example.springframwork.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("All")
//@ContextConfiguration(classes = SpringConfig.class)
@SpringJUnitConfig(SpringConfig.class)
@Slf4j
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;


//    @AfterEach
//    public void 데이터삭제() {
//        userDao.deleteAll();
//    }

    @BeforeEach
    public void 유저디폴트생성() {
        User user1 = new User();
        user1.setName("안녕");
        user1.setEmail("안녕@m.com");
        userService.add(user1);
        User user = new User();
        user.setName("두번째");
        user.setEmail("두번째@m.com");
        User user2 = new User();
        user2.setName("세번째");
        user2.setEmail("세번째@m.com");
        User user3 = new User();
        user3.setName("서어");
        user3.setEmail("서어@na.com");
        userService.add(user2);
        userService.add(user);
    }

    @Test
    public void 유저생성() {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        UserDao userDao1 = applicationContext.getBean("userDao", UserDao.class);
        User user = new User();
        user.setName("lsek");
        user.setEmail("hello@spring.io");

        userService.add(user);
    }

    @Test
    public void 유저리스트() {
        List<User> all = userService.getAll();
//        log.debug(all.toString());
//        System.out.println(all.toString());

        assertThat(all.size()).isEqualTo(3);
    }

    @Test
    public void 유저하나겟() {
        User user = userDao.get(13);
        assertThat(user.getName()).isEqualTo("안녕");
    }


}
