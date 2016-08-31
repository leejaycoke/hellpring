package com.hellpring.controller;

import com.hellpring.command.LoginCommand;
import com.hellpring.dao.UserDAO;
import com.hellpring.model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserDAO postDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.addObject("email", "lee@lee.com");
        response.setViewName("user/login.jsp");

        Optional<UserModel> optUser = userDAO.select(1);
        LOGGER.debug("user={}", optUser.isPresent() ? optUser.get().toString() : "");
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@ModelAttribute("test") LoginCommand model, Errors errors) {
        LOGGER.debug("email={}", model.getEmail());
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
