package com.example.springboot.mapper;

import com.example.springboot.model.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 阿康
 */

@Repository
public interface UserMapper {

    /**
     * 根据主键查询对象信息
     * @param id 主键
     * @return 对象
     */
    UserEntity getUserById(Integer id);

    /**
     * 根据用户名查询对象信息
     * @param userName 用户名
     * @return 用户信息
     */
    UserEntity getUserByUserName(String userName);
}
