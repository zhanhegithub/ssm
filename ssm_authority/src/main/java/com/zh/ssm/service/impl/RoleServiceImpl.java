package com.zh.ssm.service.impl;

import com.zh.ssm.mapper.AuthRoleMapper;
import com.zh.ssm.mapper.RoleMapper;
import com.zh.ssm.pojo.AuthRoleExample;
import com.zh.ssm.pojo.AuthRoleKey;
import com.zh.ssm.pojo.Role;
import com.zh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthRoleMapper authRoleMapper;
    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleMapper.selectByExample(null);
        return roleList;
    }

    @Override
    @Transactional
    public void saveRoleAuthMapping(Integer[] aid, Integer rid) {
        AuthRoleExample authRoleExample = new AuthRoleExample();
        AuthRoleExample.Criteria criteria = authRoleExample.createCriteria();
        criteria.andRidEqualTo(rid);
        authRoleMapper.deleteByExample(authRoleExample);
        if(aid!=null) {
            for (Integer a : aid) {
                AuthRoleKey authRoleKey = new AuthRoleKey();
                authRoleKey.setAid(a);
                authRoleKey.setRid(rid);
                authRoleMapper.insert(authRoleKey);
            }
        }
    }

    /**
     * 此方法是通过角色的主键id查询它的所有权限的id
     * @param rid
     * @return
     */
    @Override
    public String findRoleById(Integer rid) {
        AuthRoleExample authRoleExample = new AuthRoleExample();
        AuthRoleExample.Criteria criteria = authRoleExample.createCriteria();
        criteria.andRidEqualTo(rid);
        List<AuthRoleKey> authRoleKeys = authRoleMapper.selectByExample(authRoleExample);
        ArrayList<Integer> list = new ArrayList<>();
        for (AuthRoleKey authRoleKey : authRoleKeys) {
            list.add(authRoleKey.getAid());
        }
        return list.toString();
    }
}
