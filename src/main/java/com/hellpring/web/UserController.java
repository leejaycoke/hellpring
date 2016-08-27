package com.hellpring.web;

import com.hellpring.command.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "hellow world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(LoginCommand loginCommand, Errors errors) {

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
