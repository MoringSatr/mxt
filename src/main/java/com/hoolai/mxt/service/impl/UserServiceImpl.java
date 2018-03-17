package com.hoolai.mxt.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoolai.mxt.common.Constant;
import com.hoolai.mxt.common.ErrorCode;
import com.hoolai.mxt.common.TextFilter;
import com.hoolai.mxt.common.idcard.IdCardValidator;
import com.hoolai.mxt.entity.User;
import com.hoolai.mxt.repository.UserRepository;
import com.hoolai.mxt.service.UserService;
import com.hoolai.mxt.vo.ResultVo;

/**
 * @author liubowen
 * @date 2018/3/16 17:40
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResultVo login(String username, String password) {
        ResultVo result = ResultVo.ok();
        if (StringUtils.isBlank(username)) {
            return new ResultVo(ErrorCode.NOT_INPUT_USERNAME);
        }
        if (StringUtils.isBlank(password)) {
            return new ResultVo(ErrorCode.NOT_INPUT_PASSWORD);
        }
        boolean checkUsername = this.userRepository.checkUsername(username) == 1 ? true : false;
        if (!checkUsername) {
            return new ResultVo(ErrorCode.NOT_REGISTE);
        }
        boolean checkUsernameAndPassword = this.userRepository.checkUsernameAndPassword(username, password) == 1 ? true : false;
        if (!checkUsernameAndPassword) {
            return new ResultVo(ErrorCode.ERROR_PASSWORD);
        }
        result.put("gameUrl", Constant.GAME_URL);
        return result;
    }

    @Override
    public ResultVo register(String username, String password, String realname, String idcard, boolean accept) {
        if (!accept) {
            return new ResultVo(ErrorCode.NOT_ACCEPT_PROTOCOL);
        }
        if (StringUtils.isBlank(username)) {
            return new ResultVo(ErrorCode.NOT_INPUT_USERNAME);
        }
        if (StringUtils.isBlank(password)) {
            return new ResultVo(ErrorCode.NOT_INPUT_PASSWORD);
        }
        if (StringUtils.isBlank(realname)) {
            return new ResultVo(ErrorCode.NOT_INPUT_REALNAME);
        }
        if (StringUtils.isBlank(idcard)) {
            return new ResultVo(ErrorCode.NOT_INPUT_IDCARD);
        }
        if (TextFilter.hasDirtyWord(username)) {
            return new ResultVo(ErrorCode.ILLEGAL_USERNAME);
        }
        if (TextFilter.hasDirtyWord(realname) || !IdCardValidator.isRealName(realname)) {
            return new ResultVo(ErrorCode.ILLEGAL_REALNAME);
        }
        if (TextFilter.hasDirtyWord(idcard) || !IdCardValidator.isIdCard(idcard)) {
            return new ResultVo(ErrorCode.ILLEGAL_IDCARD);
        }

        User user = new User();
        user.setUsername(username);
        user.setPlatformId(username);
        user.setPassword(password);
        user.setRealname(realname);
        user.setIdcard(idcard);
        this.userRepository.saveAndFlush(user);
        return ResultVo.ok();
    }

}
