package com.hoolai.mxt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liubowen
 * @date 2018/3/16 16:56
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.hoolai.mxt.repository")
public class ApplicationText {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testSave() {
        jdbcTemplate.update("insert into USER(username, password) values(?, ?)", "1111", "2222");
    }
}
