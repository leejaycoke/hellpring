package com.hellpring.controller;

import com.hellpring.command.LoginCommand;
import com.hellpring.config.DBConfig;
import com.hellpring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private DBConfig dbConfig;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login() {
        return "hellow world" + dbConfig.getDriver();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(LoginCommand loginCommand, Errors errors) {
        return "hellow world";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "hellow world";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister() {
        return "hellow world";
    }
}
