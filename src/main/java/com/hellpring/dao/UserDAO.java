package com.hellpring.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDAO {

    public int get() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("org.h2.Driver");
            ds.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
            ds.setUser("sa");
            ds.setPassword("");
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        new JdbcTemplate(ds).query("SELECT COUNT(*) FROM user", new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return 1;
            }
        });

        return 1;
    }
}
