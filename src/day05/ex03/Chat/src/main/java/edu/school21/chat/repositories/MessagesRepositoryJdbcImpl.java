package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private DataSource ds;

    public MessagesRepositoryJdbcImpl(HikariDataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) {
        Optional<Message> optionalMessage = Optional.empty();
        try {
            Connection connection = ds.getConnection();
            String query = "SELECT * FROM chat.message WHERE id=" + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            User user = new User(1L, "wolf", "trewq", null, null);
            Chatroom chatroom = new Chatroom(1L, "Cooking", user, null);
            Message message = new Message(resultSet.getLong(1), user, chatroom, resultSet.getString("mtext"), LocalDateTime.of(2022,04,24,19,15));
            optionalMessage = Optional.of(message);

            resultSet.close();
            connection.close();
            statement.close();
            return optionalMessage;
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public void update(Message message){
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = ds.getConnection();
            String query = "update chat.message set " +
                    "author = " + (message.getAuthor() == null ? null : message.getAuthor().getId()) + "," +
                    "mtext = " + (message.getText() == null ? null : "'" + message.getText() + "'") + "," +
                    "mdate = " + (message.getDateTime() == null ? null : "'" + message.getDateTime() + "'") +
                    " where id = " + message.getId();
            preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1)
                System.out.println("Message update");
            else
                System.out.println("Can not message update");
            preparedStatement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            throw new NotSavedSubEntityException();
        }

    }
}
