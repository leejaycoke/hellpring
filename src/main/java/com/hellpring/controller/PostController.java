package com.hellpring.controller;

import com.hellpring.command.WriteForm;
import com.hellpring.model.PostModel;
import com.hellpring.service.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    private final static Logger LOGGER = LogManager.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        List<PostModel> posts = postService.getAll();

        ModelAndView response = new ModelAndView();
        response.addObject("posts", posts);
        response.setViewName("post/list.jsp");
        return response;
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(@ModelAttribute("write") WriteForm writeForm) {
        return "post/write.jsp";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String doWrite(@ModelAttribute("write") @Valid WriteForm writeForm, BindingResult bindingResult,
                          HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "post/write.jsp";
        }

        PostModel post = new PostModel();
        post.setUserId(1);
        post.setTitle(writeForm.getTitle());
        post.setContent(writeForm.getContent());
        postService.write(post);
        return "redirect:/post/list";
    }

}
