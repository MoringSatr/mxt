package com.hoolai.mxt.service;

import com.hoolai.mxt.vo.ResultVo;

/**
 * @author liubowen
 * @date 2018/3/16 17:39
 * @description
 */
public interface UserService {

    /** 登陆 */
    ResultVo login(String username, String password);

    /** 注册 */
    ResultVo register(String username, String password, String realname, String idcard, boolean accept);

}
