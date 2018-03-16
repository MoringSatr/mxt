package com.hoolai.mxt.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liubowen
 * @date 2018/3/16 16:33
 * @description
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "platformId")
    private String platformId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "idcard")
    private String idcard;

    @Column(name = "realname")
    private String realname;

}
