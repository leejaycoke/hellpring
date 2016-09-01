package com.hellpring.dao;

import com.hellpring.model.PostModel;
import com.hellpring.model.UserModel;
import com.hellpring.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO extends DAO<PostModel> {

    private final static Logger LOGGER = LogManager.getLogger(PostDAO.class);

    @Autowired
    private UserDAO userDAO;

    private PostDAO() {
        super(PostModel.class);
    }

    @Override
    public int insert(PostModel model) {
        String sql = "INSERT INTO post(user_id, title, content)" +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, model.getUserId(), model.getTitle(), model.getContent());
    }

    @Override
    public RowMapper<PostModel> getRowMapper() {
        return rowMapper;
    }

    private RowMapper<PostModel> rowMapper = (rs, rowNum) -> {
        PostModel post = new PostModel();
        post.setId(rs.getInt("id"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        post.setUserId(rs.getInt("user_id"));
        post.setRegDate(rs.getTimestamp("reg_date"));

        UserModel user = userDAO.select(post.getUserId());
        post.setUser(user);
        return post;
    };
}
