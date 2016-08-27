package com.hellpring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "hellow world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin() {
        return "hellow world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String register() {
        return "hellow world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doRegister() {
        return "hellow world";
    }
}
