package com.example.springboot;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.UserEntity;
import lombok.Data;
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
    UserMapper userMapper;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

}
