package com.example.springboot.model;

import lombok.Data;


/**
 * @ClassName: User
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/5/1517:36
 */
@Data
public class UserEntity {

    private Integer id;
    private String userName;
    private String passWord;
    private String status;

}
