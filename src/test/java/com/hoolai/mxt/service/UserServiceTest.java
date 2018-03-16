package com.hoolai.mxt.service;

import com.hoolai.mxt.Application;
import com.hoolai.mxt.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        ResultVo login = this.userService.login("qq", "q");
        log.info("loginResult : {}", login);
    }

    @Test
    public void register() {
    }
}