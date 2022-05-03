package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.NotSavedSubEntityException;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/my_db");
        hikariDataSource.setUsername("cyuuki");
        hikariDataSource.setPassword("");

        MessagesRepositoryJdbcImpl messagesRepositoryJdbc = new MessagesRepositoryJdbcImpl(hikariDataSource);
        User creator = new User(1L, "user", "user", null, null);
        User author = creator;
        Chatroom chatroom = new Chatroom(2L, "room", creator, null);
        Message message = new Message(null, author, chatroom, "new Message", LocalDateTime.now());
        try {
            messagesRepositoryJdbc.save(message);
            System.out.println(message.getId());
        }
        catch(NotSavedSubEntityException e)
        {
            e.printErr();
        }
    }
}