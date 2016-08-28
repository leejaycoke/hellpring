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
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1");
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            System.out.println("driver=" + driver);
            ds.setDriverClass("org.h2.Driver");
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        ds.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
        ds.setUser("sa");
        ds.setPassword("");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2" + ds.toString());
        return ds;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
