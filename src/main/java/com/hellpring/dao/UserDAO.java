package com.hellpring.dao;

import com.hellpring.controller.UserController;
import com.hellpring.model.UserModel;
import com.hellpring.model.annotations.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAO extends DAO<UserModel> {

    private final static Logger LOGGER = LogManager.getLogger(UserController.class);

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

    @Override
    public RowMapper<List<UserModel>> getRowsMapper() {
        return rowsMapper;
    }

    private RowMapper<UserModel> rowMapper = (rs, rowNum) -> {
        UserModel user = new UserModel();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    };

    private RowMapper<List<UserModel>> rowsMapper = (rs, rowNum) -> {
        List<UserModel> users = new ArrayList<>();

        while (rs.next()) {
            UserModel user = new UserModel();
            user.setId(rs.getInt("id"));
            users.add(user);
        }

        return users;
    };
}
