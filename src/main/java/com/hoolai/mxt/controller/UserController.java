package com.hoolai.mxt.controller;

import com.google.common.collect.Maps;
import com.hoolai.mxt.repository.UserRepository;
import com.hoolai.mxt.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author liubowen
 * @date 2018/3/16 11:14
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /** 登陆页面 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        modelAndView.addObject("serverUrl", "http://127.0.0.1:10088/");
        return modelAndView;
    }

    /** 协议页面 */
    @RequestMapping(value = "/checkProtocol", method = RequestMethod.GET)
    public ModelAndView checkProtocol() {
        ModelAndView modelAndView = new ModelAndView("/user/checkProtocol");
        modelAndView.addObject("serverUrl", "http://127.0.0.1:10088/");
        return modelAndView;
    }

    /** 注册页面 */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam("accept") boolean accept) {
        ModelAndView modelAndView = new ModelAndView("/user/register");
        modelAndView.addObject("serverUrl", "http://127.0.0.1:10088/");
        modelAndView.addObject("accept", accept);
        return modelAndView;
    }

    /** 登陆 */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo login(@RequestParam("username") String username, @RequestParam("password") String password) {
        ResultVo result = ResultVo.ok();
        result.put("gameUrl", "http://47.93.96.219/firedog/index.html");
        return result;
    }

    /** 注册 */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("realname") String realname,
            @RequestParam("idcard") String idcard, @RequestParam("accept") boolean accept) {
        return ResultVo.ok();
    }

    /** 注册 */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> test() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("code", "aa");
        return result;
    }

}
