package com.hoolai.mxt;

import com.hoolai.mxt.entity.User;
import com.hoolai.mxt.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liubowen
 * @date 2018/3/16 16:56
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        List<User> allByUsername = this.userRepository.findAllByUsername("qqq");
        log.info("allByUsername : {}", allByUsername.size());
    }


    @Test
    public void checkUsername() {
        int checkUsername = this.userRepository.checkUsername("q");
        log.info("checkUsername : {}", checkUsername);
    }
}
