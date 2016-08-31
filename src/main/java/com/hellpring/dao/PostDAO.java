package com.hellpring.dao;

import com.hellpring.model.PostModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PostDAO extends DAO<PostModel> {

    private PostDAO() {
        super(PostModel.class);
    }

    private RowMapper<PostModel> rowMapper = (rs, rowNum) -> {
        PostModel post = new PostModel();
        return post;
    };

    @Override
    public void delete(int id) {

    }

    @Override
    public RowMapper<PostModel> getRowMapper() {
        return rowMapper;
    }
}
