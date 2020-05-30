package com.example.springboot.service;

import com.example.springboot.model.UserEntity;

/**
 * @author 阿康
 * @ClassName: UserService
 * @description:
 * @date 2020/5/29
 */
public interface UserService {

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
