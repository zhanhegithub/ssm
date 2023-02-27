package com.zh.ssm.service.impl;

import com.zh.ssm.mapper.AuthMapper;
import com.zh.ssm.mapper.AuthRoleMapper;
import com.zh.ssm.mapper.UserMapper;
import com.zh.ssm.mapper.UserRoleMapper;
import com.zh.ssm.pojo.*;
import com.zh.ssm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<User> findAll() {

        return userMapper.selectByExample(null);
    }

    @Override
    @Transactional
    public void saveUserRoleMapping(Integer[] rid, Integer uid) {
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUidEqualTo(uid);
        //先通过UID吧此用户的所有角色删除
        userRoleMapper.deleteByExample(userRoleExample);
        if (rid!=null) {
            for (Integer r : rid) {
                UserRoleKey userRoleKey = new UserRoleKey();
                userRoleKey.setUid(uid);
                userRoleKey.setRid(r);
                userRoleMapper.insert(userRoleKey);
            }
        }
    }

    @Override
    public String findUserByUid(Integer uid) {
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUidEqualTo(uid);
        List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(userRoleExample);
        ArrayList<Integer> list = new ArrayList<>();
        for (UserRoleKey userRoleKey : userRoleKeys) {
            list.add(userRoleKey.getRid());
        }

        return list.toString();
    }

    @Override
    public UserVo login(User user) {
        if (user == null){
            return null;
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 0){
            User myuser = userList.get(0);
            List<Auth> authList = authMapper.findPathByUid(myuser.getUid());
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(myuser,userVo);
            /*userVo.setUid(user.getUid());
            userVo.setPassword(user.getPassword());
            userVo.setUsername(user.getUsername());
            userVo.setAge(user.getAge());
            userVo.setSex(user.getSex());*/
            userVo.setAuthList(authList);
            return userVo;
        }else {
            return null;
        }
    }
}
