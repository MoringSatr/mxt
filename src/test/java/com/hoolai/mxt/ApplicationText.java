package com.hoolai.mxt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoolai.mxt.entity.UserEntity;
import com.hoolai.mxt.repository.UserRepository;

/**
 * @author liubowen
 * @date 2018/3/16 16:56
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationText {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("111");
        userEntity.setPassword("111");
        userRepository.saveAndFlush(userEntity);
        System.err.println(userEntity);
    }
}
