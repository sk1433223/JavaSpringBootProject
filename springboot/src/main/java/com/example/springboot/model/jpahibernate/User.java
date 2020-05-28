package com.example.springboot.model.jpahibernate;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName: UserJpa
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/5/1814:29
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "pass_word", length = 50)
    private String passWord;

    @Column(name = "status", length = 1)
    private String status;

}
