package com.hellpring.dao;

import com.hellpring.model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO extends DAO<UserModel> {

    private final static Logger LOGGER = LogManager.getLogger(UserDAO.class);

    private UserDAO() {
        super(UserModel.class);
    }

    @Override
    public int insert(UserModel model) {
        String sql = "INSERT INTO user(email, password)" +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql, model.getEmail(), model.getPassword());
    }

    public UserModel selectByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, email);
    }

    @Override
    public RowMapper<UserModel> getRowMapper() {
        return rowMapper;
    }

    private RowMapper<UserModel> rowMapper = (rs, rowNum) -> {
        UserModel user = new UserModel();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    };

}
