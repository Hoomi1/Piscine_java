package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.NotSavedSubEntityException;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 *
 * @author Your name
 */
public class Program {
    public static void main(String[] args) {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/my_db");
        hikariDataSource.setUsername("cyuuki");
        hikariDataSource.setPassword("");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(hikariDataSource);
        User user = new User(3L, "qwer", "qwer", null, null);

        try {
            Optional<Message> messageOptional = repository.findById(5L);
            if (messageOptional.isPresent()) {
                Message message = messageOptional.get();
                message.setAuthor(user);
                message.setDateTime(null);
                repository.update(message);
            }
        }
        catch(NotSavedSubEntityException e)
        {
            e.printErr();
        }
    }
}