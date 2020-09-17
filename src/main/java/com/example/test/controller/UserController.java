package com.example.test.controller;

import com.example.test.pojo.User;
import com.example.test.service.UserService;
import com.example.test.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@Slf4j
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public ResultVo login (User user, String roles, HttpServletRequest request) {
        ResultVo resultVo = new ResultVo();
        Boolean isExist = userService.login(user, roles, request);
        if (isExist) {
            resultVo.setMsg("登录成功");
            log.debug("【用户登录】：成功，对应的用户实体为：{}",user);
        } else {
            resultVo.setCode("500");
            resultVo.setMsg("用户或者密码错误");
            resultVo.setSuccess(false);
            log.error("【用户登录】：失败，对应的用户实体为：{}",user);
        }
        return resultVo;
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @GetMapping("logout")
    public ResultVo logout (HttpServletRequest request) {
        ResultVo resultVo = new ResultVo();
        request.getSession().setAttribute("user", null);
        resultVo.setMsg("注销成功");
        return resultVo;
    }


}
