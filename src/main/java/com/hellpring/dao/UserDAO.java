package com.hellpring.dao;

import com.hellpring.config.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(DataSource dataSource) {
        System.out.println(">>>>>>>>>>>>>>>> userDAO start: " + dataSource.toString());
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int get() {
        System.out.println(">>>>>>>>>>jdbcTemplate ==" + String.valueOf(jdbcTemplate == null));
        jdbcTemplate.query("SELECT COUNT(*) FROM user", new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return 1;
            }
        });

        return 1;
    }
}
