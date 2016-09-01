package com.hellpring.controller;

import com.hellpring.command.LoginForm;
import com.hellpring.command.RegisterForm;
import com.hellpring.model.UserModel;
import com.hellpring.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("login") LoginForm loginForm, @CookieValue(value = "remember", required = false) Cookie cookie) {
        if (cookie != null) {
            String email = cookie.getValue();
            loginForm.setEmail(email);
            loginForm.setRemember(true);
        }

        return "user/login.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("login") @Valid LoginForm loginForm, BindingResult bindingResult,
                          HttpSession session, HttpServletResponse response) {
        LOGGER.debug("loginForm={}", loginForm.toString());

        LOGGER.debug("hasErrors={}", bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            return "user/login.jsp";
        }

        UserModel user = userService.login(loginForm.getEmail(), loginForm.getPassword());
        if (user == null) {
            bindingResult.reject("password", "아이디 혹은 비밀번호가 틀립니다.");
            LOGGER.debug("아이디 혹은 비밀번호가 틀립니다. email={}, password={}", loginForm.getEmail(), loginForm.getPassword());
            return "user/login.jsp";
        }

        if (loginForm.isRemember()) {
            Cookie cookie = new Cookie("remember", loginForm.getEmail());
            response.addCookie(cookie);
        }

        session.setAttribute("user_id", user.getId());

        return "redirect:/post/list";
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

        return "redirect:/user/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }
}
