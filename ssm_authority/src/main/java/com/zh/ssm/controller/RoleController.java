package com.zh.ssm.controller;

import com.zh.ssm.pojo.Auth;
import com.zh.ssm.pojo.Role;
import com.zh.ssm.service.AuthService;
import com.zh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/roleController")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthService authService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "auth/findRole";
    }

    @RequestMapping("/configureAuth")
    public String configureAuth(Integer rid,Model model){
        model.addAttribute("rid",rid);
        List<Auth> authList = authService.findAll();
        model.addAttribute("authList",authList);
        String aids = roleService.findRoleById(rid);
        model.addAttribute("aids",aids);
        return "auth/configureAuth";

    }
    @RequestMapping("/saveRoleAuthMapping")
    public String saveRoleAuthMapping(Integer[] aid,Integer rid,Model model){
        roleService.saveRoleAuthMapping(aid,rid);
        return this.findAll(model);
    }
}
