package com.hoolai.mxt.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liubowen
 * @date 2018/3/16 21:02
 * @description
 */
@Component
public class LoadConfig {

    @Value("${spring.profiles.active}")
    private String springProfiles;

    @PostConstruct
    public void load() {
        Constant.load(springProfiles);
    }
}
