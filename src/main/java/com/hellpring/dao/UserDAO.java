package com.hellpring.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
