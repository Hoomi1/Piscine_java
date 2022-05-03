package edu.school21.sockets.server;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import edu.school21.sockets.services.UsersService;
import edu.school21.sockets.services.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Component
@Parameters(separators = "=")
public class Server {

    @Parameter(names = "--port")
    private Integer arg;

    @Autowired
    private UsersService usersService;


    public void run()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(arg);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Server start");
            out.write("Hello from Server!\n");
            out.flush();
            if (in.readLine().equals("signUp"))
            {
                out.write("Enter username:\n");
                out.flush();
                String name = in.readLine();
//                usersService.setName(in.readLine());
                out.write("Enter password:\n");
                out.flush();
                String password = in.readLine();
//                usersService.setPassword(in.readLine());
                out.write("Successful!\n");
                out.flush();
//                usersService.signUp(usersService.getName(), usersService.getPassword());
                usersService.signUp(name, password);
            }
            else {
                out.write("Bad connect!\n");
                out.flush();
                System.out.println("Bad connect!");
            }
            socket.close();
            in.close();
            out.close();
            return ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
