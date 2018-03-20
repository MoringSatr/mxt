package com.hoolai.mxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hoolai.mxt.common.Constant;
import com.hoolai.mxt.common.Util;
import com.hoolai.mxt.service.UserService;
import com.hoolai.mxt.vo.ResultVo;

/**
 * @author liubowen
 * @date 2018/3/16 11:14
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /** 登陆页面 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("user/login");
        Util.addLocalInfo(modelAndView);
        return modelAndView;
    }

    /** 协议页面 */
    @RequestMapping(value = "/checkProtocol", method = RequestMethod.GET)
    public ModelAndView checkProtocol() {
        ModelAndView modelAndView = new ModelAndView("user/checkProtocol");
        Util.addLocalInfo(modelAndView);
        return modelAndView;
    }

    /** 注册页面 */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam("accept") boolean accept) {
        ModelAndView modelAndView = new ModelAndView("user/register");
        Util.addLocalInfo(modelAndView);
        modelAndView.addObject("accept", accept);
        return modelAndView;
    }

    /** 游戏忠告页面 */
    @RequestMapping(value = "/advice", method = RequestMethod.GET)
    public ModelAndView advice() {
        ModelAndView modelAndView = new ModelAndView("user/advice");
        Util.addLocalInfo(modelAndView);
        modelAndView.addObject("gameUrl", Constant.GAME_URL);
        return modelAndView;
    }

    /** 登陆 */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.login(username, password);
    }

    /** 注册 */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("realname") String realname,
            @RequestParam("idcard") String idcard, @RequestParam("accept") boolean accept) {
        return userService.register(username, password, realname, idcard, accept);
    }

}
