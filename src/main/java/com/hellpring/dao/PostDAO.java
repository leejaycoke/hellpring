package com.hellpring.dao;

import com.hellpring.model.PostModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO extends DAO<PostModel> {

    private final static Logger LOGGER = LogManager.getLogger(PostDAO.class);

    private PostDAO() {
        super(PostModel.class);
    }

    @Override
    public int insert(PostModel model) {
        String sql = "INSERT INTO post(title, content)" +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql, model.getTitle(), model.getContent());
    }

    @Override
    public RowMapper<PostModel> getRowMapper() {
        return rowMapper;
    }

    @Override
    public RowMapper<List<PostModel>> getRowsMapper() {
        return rowsMapper;
    }

    private RowMapper<List<PostModel>> rowsMapper = (rs, rowNum) -> {
        List<PostModel> posts = new ArrayList<>();

        if (rowNum == 0) {
            return posts;
        }

        while (rs.next()) {
            PostModel post = new PostModel();
            post.setId(rs.getInt("id"));
            posts.add(post);
        }

        return posts;
    };

    private RowMapper<PostModel> rowMapper = (rs, rowNum) -> {
        if (rowNum == 0) {
            return null;
        }

        PostModel post = new PostModel();
        post.setId(rs.getInt("id"));
        return post;
    };
}
