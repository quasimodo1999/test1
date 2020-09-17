package com.example.test.mapper;


import com.example.test.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface UserMapper extends BaseMapper<User> {

}