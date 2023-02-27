package com.zh.ssm.service;

import com.zh.ssm.pojo.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();
    public void saveRoleAuthMapping(Integer[] aid,Integer rid);
    public String findRoleById(Integer rid);
}
