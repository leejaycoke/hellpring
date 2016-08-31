package com.hellpring.dao;

import com.hellpring.controller.UserController;
import com.hellpring.model.Model;
import com.hellpring.model.UserModel;
import com.hellpring.model.annotations.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationConfigurationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class DAO<T extends Model> {

    private final static Logger LOGGER = LogManager.getLogger(UserController.class);

    private String tableName;

    private JdbcTemplate jdbcTemplate;

    private Class clazz;

    DAO(Class<T> clazz) {
        LOGGER.debug("dao init called");

        this.clazz = clazz;

        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new AnnotationConfigurationException("table is required");
        }

        Table tableAnnotation = clazz.getDeclaredAnnotation(Table.class);
        tableName = tableAnnotation.name();
    }

    @Autowired
    private void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<T> select(int id) {
        LOGGER.debug("select id={}, tableName={}", id, tableName);

        String sql = String.format("SELECT * FROM %s WHERE id = ?", tableName);
        List<T> models = jdbcTemplate.queryForObject(sql, getRowMapper(), id);
        return models.size() > 0 ? Optional.of(models.get(0)) : Optional.empty();
    }

    public List<T> selectAll() {
        return null;
    }

    public Optional<T> insert(T model) {
        return null;
    }

    public void delete(int id) {

    }

    public abstract RowMapper<List<T>> getRowMapper();

}
