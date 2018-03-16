package com.hoolai.mxt.repository;

import com.hoolai.mxt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author liubowen
 * @date 2018/3/16 16:39
 * @description
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    @Query(value = "select count(0) > 0 from user where username = :username", nativeQuery = true)
    int checkUsername(@Param("username") String username);

    @Query(value = "select count(0) > 0 from user where username = :username and password = :password", nativeQuery = true)
    int checkUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
