package com.hellpring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {SpringWebConfig.class})
@PropertySource("classpath:db.properties")
public class DBConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${driver}")
    private String driver;

    @Value("${uri}")
    private String uri;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            System.out.println("driver=" + driver);
            ds.setDriverClass(driver);
            ds.setJdbcUrl(uri);
            ds.setUser("root");
            ds.setPassword(password);
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2" + ds.toString());
        return ds;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
