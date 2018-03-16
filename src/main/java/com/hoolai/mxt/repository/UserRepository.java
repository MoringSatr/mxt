package com.hoolai.mxt.repository;

import com.hoolai.mxt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liubowen
 * @date 2018/3/16 16:39
 * @description
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
