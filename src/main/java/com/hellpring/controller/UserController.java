package com.hellpring.controller;

import com.hellpring.command.LoginForm;
import com.hellpring.command.RegisterForm;
import com.hellpring.dao.UserDAO;
import com.hellpring.model.UserModel;
import com.hellpring.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "user/login.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("login") @Valid LoginForm loginForm, BindingResult bindingResult,
                          HttpSession session) {
        LOGGER.debug("hasErrors={}", bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            return "user/login.jsp";
        }

        UserModel user = userService.login(loginForm.getEmail(), loginForm.getPassword());
        if (user == null) {
            ObjectError error = new ObjectError("password", "아이디 혹은 비밀번호가 틀립니다.");
            bindingResult.addError(error);
            LOGGER.debug("hasErrors={}", bindingResult.hasErrors());
            return "user/login.jsp";
        }

        session.setAttribute("user_id", user.getId());

        return "redirect:/post/list.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "user/register.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("register") @Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/register.jsp";
        }

        UserModel user = new UserModel();
        user.setEmail(registerForm.getEmail());
        user.setPassword(registerForm.getPassword());
        userService.register(user);

        return "redirect:/user/login.jsp";
    }
}
