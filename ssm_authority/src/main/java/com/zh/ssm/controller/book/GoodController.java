package com.zh.ssm.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/goodController")
public class GoodController {
    @RequestMapping("/findGood")
    public String findGood(){
        return "book/success";
    }
    @RequestMapping("/saveGood")
    public String saveGood(){
        return "book/success";
    }
    @RequestMapping("/updateGood")
    public String updateGood(){
        return "book/success";
    }
    @RequestMapping("/deleteGood")
    public String deleteGood(){
        return "book/success";
    }
}
