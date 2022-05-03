package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{
    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource driverManagerDataSource) {
        this.jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }

    private RowMapper<User> rowMapper = (user, rowMapper) ->
            new User
                    (
                    user.getLong(1),
                    user.getString(2)
                    );


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
        jdbcTemplate.update("INSERT INTO users VALUES(?, ?);", entity.getIdentifier(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET email=?;", entity.getEmail());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE identifier=?;", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM users WHERE email=?;", rowMapper, email).stream().findAny();
    }
}
