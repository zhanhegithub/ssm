package com.zh.ssm.service;

import com.zh.ssm.pojo.User;
import com.zh.ssm.pojo.UserVo;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void saveUserRoleMapping(Integer [] rid,Integer uid);
    public String findUserByUid(Integer uid);

    public UserVo login(User user);
}
