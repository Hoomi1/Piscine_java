package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component("jdbcTemplate")
public class UsersRepositoryImpl implements UsersRepository{

    JdbcTemplate    jdbcTemplate;

    @Autowired
    public UsersRepositoryImpl(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> rowMapper = (user, rowMap) ->
        new User(user.getLong(1), user.getString(2), user.getString(3));

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE identifier=?;", rowMapper, id).stream().findAny().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users;", rowMapper);
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users(name, password) VALUES(?, ?);", entity.getName(), entity.getPassword());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET name=?;", entity.getName());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE identifier=?;", id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return jdbcTemplate.query("SELECT * FROM users WHERE name=?;", rowMapper, name).stream().findAny();
    }
}
