package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private DataSource ds;

    public MessagesRepositoryJdbcImpl(HikariDataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage = Optional.empty();
        Connection connection = ds.getConnection();

        String query = "SELECT * FROM chat.message WHERE id=" + id;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        User user = new User(1, "wolf", "trewq", null, null);
        Chatroom chatroom = new Chatroom(1, "Cooking", user, null);
        Message message = new Message(resultSet.getLong(1), user, chatroom, resultSet.getString("mtext"), LocalDateTime.of(2022,04,24,19,15));
        optionalMessage = Optional.of(message);

        resultSet.close();
        connection.close();
        statement.close();

        return optionalMessage;
    }

    @Override
    public void save(Message message) {
        try {
            Connection connection = ds.getConnection();
            String query = "INSERT INTO chat.message (author, room, mtext, mdate) VALUES (" + message.getAuthor().getId() + ", " + message.getRoom().getId() + ", '" + message.getText() + "', '" + message.getDateTime() +"');";
            Statement statement = connection.createStatement();
            String queryId = "select id from chat.message order by id desc limit 1";
            boolean result = statement.execute(query);
            ResultSet resultSet = statement.executeQuery(queryId);
            resultSet.next();
            message.setId(resultSet.getLong(1));
            resultSet.close();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }


    }
}
