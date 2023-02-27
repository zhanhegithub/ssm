package com.zh.ssm.controller;

import com.zh.ssm.pojo.Role;
import com.zh.ssm.pojo.User;
import com.zh.ssm.service.RoleService;
import com.zh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public String  findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "auth/findUser";
    }

    @RequestMapping("/configureRole")
    public String configureRole(Model model,Integer uid){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        model.addAttribute("uid",uid);
        String rids = userService.findUserByUid(uid);
        model.addAttribute("rids",rids);
        return "auth/configureRole";
    }
    @RequestMapping("/saveUserRoleMapping")
    public String saveUserRoleMapping(Integer [] rid,Integer uid,Model model){
        userService.saveUserRoleMapping(rid,uid);
        return this.findAll(model);
    }

}
