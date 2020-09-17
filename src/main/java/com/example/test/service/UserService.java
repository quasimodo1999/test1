package com.example.test.service;



import com.example.test.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     * 判断用户是否存在,存在就将user存入session中
     * @param user
     * @return
     */
    Boolean login(User user, String roles, HttpServletRequest request);

}
