package com.zh.ssm.controller.book;

import com.zh.ssm.pojo.User;
import com.zh.ssm.pojo.UserVo;
import com.zh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/bookController")
public class BookController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model){
        UserVo myuser = userService.login(user);
        if (myuser != null){
            session.setAttribute("myuser",myuser);
            return "book/main";
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "book/login";
        }
    }
    @RequestMapping("/findBook")
    public String findBook(){
        return "book/success";
    }
    @RequestMapping("/saveBook")
    public String saveBook(){
        return "book/success";
    }
    @RequestMapping("/updateBook")
    public String updateBook(){
        return "book/success";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(){
        return "book/success";
    }

}
