package com.hoolai.mxt.repository;

import com.hoolai.mxt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author liubowen
 * @date 2018/3/16 16:39
 * @description
 */
@Component
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsernameAndPassword(String username, String password);

}
