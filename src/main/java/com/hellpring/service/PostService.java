package com.hellpring.service;

import com.hellpring.dao.PostDAO;
import com.hellpring.model.PostModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostService {

    private final static Logger LOGGER = LogManager.getLogger(PostService.class);

    @Autowired
    private PostDAO postDAO;

    public List<PostModel> getAll() {
        return postDAO.selectAll();
    }

    public int write(PostModel post) {
        return postDAO.insert(post);
    }
}
