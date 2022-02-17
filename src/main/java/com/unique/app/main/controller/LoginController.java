package com.unique.app.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

//    로그인 화면
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginPage() {

        return "views/login";
    }
//    로그인
}
