package com.example.test.service.Impl;



import com.example.test.mapper.UserMapper;
import com.example.test.pojo.User;
import com.example.test.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean login(User user, String roles, HttpServletRequest request) {
        List<User> users = userMapper.select(user);
        List<User> list = users.stream().filter(obj -> obj != null && obj.getRole().contains(roles)).collect(Collectors.toList());
        if (list.size() > 0) {
            User user1 = list.get(0);
            user1.setPassword("");
            request.getSession().setAttribute("user", user1);
            return true;
        }
        return false;
    }

}
