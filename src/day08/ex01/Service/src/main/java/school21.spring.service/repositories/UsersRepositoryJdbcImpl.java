package school21.spring.service.repositories;

import com.zaxxer.hikari.HikariDataSource;
import school21.spring.service.models.User;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository{
    private HikariDataSource dataSource;

    public UsersRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findById(Long id) {
        Connection connection = null;
        User user = null;
        try {
            connection = dataSource.getConnection();
            String query = "SELECT * FROM users WHERE identifier=" + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next())
                throw new SQLException("SQLException");
            user = new User(
                    resultSet.getLong(1),
                    resultSet.getString(2)
            );
            resultSet.close();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            while (resultSet.next())
                userList.add(new User(resultSet.getLong(1), resultSet.getString("email")));
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User entity) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String query = "INSERT INTO users (identifier, email) VALUES (" + entity.getIdentifier() + ", '" + entity.getEmail() + "');";
            Statement statement = connection.createStatement();
            statement.execute(query);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String query = "UPDATE users SET email = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, entity.getIdentifier());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM users WHERE identifier = " + id;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email='" + email + "';";
        Connection connection = null;
        ResultSet resultSet;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                return Optional.of(new User(resultSet.getLong(1), resultSet.getString(2)));

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Optional.empty();

    }
}
