package edu.school21.chat.app;


import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    static public HikariDataSource hikariDataSource = new HikariDataSource();
    public static void main(String[] args) {

        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/my_db");
        hikariDataSource.setUsername("cyuuki");
        hikariDataSource.setPassword("");

        System.out.println("Entry a message ID");
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);

        MessagesRepositoryJdbcImpl messagesRepositoryJdbc = new MessagesRepositoryJdbcImpl(hikariDataSource);
        try {
            Optional<Message> message =
                    messagesRepositoryJdbc.findById(scanner.nextLong());
            System.out.println(message.get().toString());
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}