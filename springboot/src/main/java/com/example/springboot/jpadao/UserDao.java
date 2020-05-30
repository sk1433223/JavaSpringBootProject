package com.example.springboot.jpadao;

import com.example.springboot.model.jpahibernate.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @ClassName: UserDao
 * @Description: JPA DAO层的写法
 * @Author: 阿康
 * @DateTime: 2020/5/1814:36
 */
//@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    /**
     * 根据id查询对象
     * @param id 主键
     * @return User对象
     */
    @Query(nativeQuery = true, value = "SELECT * FROM  user where user.id=?1")
    User getUserById(Integer id);

    /**
     * 根据id查询对象集合
     * @param id 主键
     * @return List<User>
     */
    List<User> getAllById(Integer id);

}
