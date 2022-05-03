package edu.school21.sockets.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.server.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
        Server server = context.getBean(Server.class);
        JCommander.
                newBuilder().
                addObject(server).
                build().
                parse(args);
        server.run();
    }

}
