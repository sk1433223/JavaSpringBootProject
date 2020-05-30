package com.example.springboot.service.impl;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.UserEntity;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 阿康
 * @ClassName: UserServiceImpl
 * @description:
 * @date 2020/5/29
 * 只读事务 @Transactional(readOnly = true)
 */
@Service
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 不需要事务管理的(只读事务)方法
     */
    @Override
    @Transactional(readOnly = true)
    public UserEntity getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }
}
