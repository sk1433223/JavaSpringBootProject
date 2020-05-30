package com.example.springboot;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.UserEntity;
import com.example.springboot.model.jpahibernate.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
class SpringbootApplicationTests {


    @Autowired
    DataSource dataSource;

    //@Autowired
    //UserDao userDao;


    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());
    }

    @Test
    public void getUserByIdTest() {
        UserEntity userById = userMapper.getUserByUserName("admin");
        System.out.println(
                userById
        );
    }

    @Test
    public void getUser() {
        //System.out.println(userDao.getUserById(1));
    }


}
