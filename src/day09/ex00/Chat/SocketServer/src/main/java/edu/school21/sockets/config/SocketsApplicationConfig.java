package edu.school21.sockets.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"edu.school21.sockets.*"})
@PropertySource("classpath:db.properties")
public class SocketsApplicationConfig {

    @Value("${db.username}")
    private String userName;

    @Value("${db.url}")
    private String url;

    @Value("${db.password}")
    private String password;

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Bean
    public PasswordEncoder BCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public DataSource dataSource()
    {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(userName);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        return hikariDataSource;
    }
}
