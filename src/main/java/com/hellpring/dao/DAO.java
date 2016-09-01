package com.hellpring.dao;

import com.hellpring.model.Model;
import com.hellpring.model.annotations.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationConfigurationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public abstract class DAO<T extends Model> {

    private final static Logger LOGGER = LogManager.getLogger(DAO.class);

    private String tableName;

    protected JdbcTemplate jdbcTemplate;

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

    public T select(int id) {
        String sql = String.format("SELECT * FROM %s WHERE id = ?", tableName);

        LOGGER.debug("sql={}", sql);

        try {
            return jdbcTemplate.queryForObject(sql, getRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            LOGGER.error(e);
            return null;
        }
    }

    public List<T> selectAll() {
        String sql = String.format("SELECT * FROM %s", tableName);

        LOGGER.debug("sql={}", sql);

        return jdbcTemplate.query(sql, getRowMapper());
    }

    public abstract int insert(T model);

    public void delete(int id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?", tableName);
        jdbcTemplate.update(sql, id);
    }

    public abstract RowMapper<T> getRowMapper();

    public abstract RowMapper<List<T>> getRowsMapper();

}
