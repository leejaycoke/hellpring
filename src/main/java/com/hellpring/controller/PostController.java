package com.hellpring.controller;

import com.hellpring.command.WriteForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    private final static Logger LOGGER = LogManager.getLogger(PostController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "post/list.jsp";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        return "post/write.jsp";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String doWrite(@ModelAttribute("write") @Valid WriteForm writeForm, BindingResult bindingResult) {
        return "post/list.jsp";
    }
//    public String doWrite(@ModelAttribute("login") @Valid LoginForm loginForm, BindingResult bindingResult,
//                          HttpSession session, HttpServletResponse response) {
//        LOGGER.debug("loginForm={}", loginForm.toString());
//
//        LOGGER.debug("hasErrors={}", bindingResult.hasErrors());
//
//        if (bindingResult.hasErrors()) {
//            return "user/login.jsp";
//        }
//
//        UserModel user = userService.login(loginForm.getEmail(), loginForm.getPassword());
//        if (user == null) {
//            bindingResult.reject("password", "아이디 혹은 비밀번호가 틀립니다.");
//            LOGGER.debug("아이디 혹은 비밀번호가 틀립니다. email={}, password={}", loginForm.getEmail(), loginForm.getPassword());
//            return "user/login.jsp";
//        }
//
//        if (loginForm.isRemember()) {
//            Cookie cookie = new Cookie("remember", loginForm.getEmail());
//            response.addCookie(cookie);
//        }
//
//        session.setAttribute("user_id", user.getId());
//
//        return "redirect:/post/list.jsp";
//    }

}
