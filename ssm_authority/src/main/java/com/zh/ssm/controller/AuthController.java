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
@RequestMapping("/authController")
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping("/findAll")
    public String  findAll(Model model){
        List<Auth> authList = authService.findAll();
        model.addAttribute("authList",authList);
        return "auth/findAuth";
    }
}
