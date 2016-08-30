package com.hellpring.controller;

import com.hellpring.command.LoginCommand;
import com.hellpring.config.DBConfig;
import com.hellpring.dao.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DBConfig dbConfig;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login() {
        return "username=" + dbConfig.getUsername() + dbConfig.toString();
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
