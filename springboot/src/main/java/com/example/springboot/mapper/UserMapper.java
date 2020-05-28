package com.example.springboot.mapper;

import com.example.springboot.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserEntity getUserById(Integer id);
}
