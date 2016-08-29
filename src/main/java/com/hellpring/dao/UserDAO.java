package com.hellpring.dao;

import com.hellpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User get() {
        User user = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", (rs, rowNum) -> {
            return new User();
        });

        return user;
    }
}
