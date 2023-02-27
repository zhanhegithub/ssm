package com.zh.ssm.service.impl;

import com.zh.ssm.mapper.AuthMapper;
import com.zh.ssm.pojo.Auth;
import com.zh.ssm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> findAll() {
        return authMapper.selectByExample(null);
    }
}
