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
    public List<UserModel> selectAll() {
        return null;
    }

    @Override
    public Optional<UserModel> insert(UserModel model) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public RowMapper<List<UserModel>> getRowMapper() {
        LOGGER.debug("getRowMapper");
        return rowMapper;
    }

    private RowMapper<List<UserModel>> rowMapper = (rs, rowNum) -> {
        LOGGER.debug("rowNum={}", rowNum);

        List<UserModel> users = new ArrayList<>();

        if (rowNum == 0) {
            return users;
        }

        while (rs.next()) {
            UserModel user = new UserModel();
            user.setId(rs.getInt("id"));
            users.add(user);
        }

        return users;
    };
}
