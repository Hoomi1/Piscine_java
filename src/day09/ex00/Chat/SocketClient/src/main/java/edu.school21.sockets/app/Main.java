package edu.school21.sockets.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.io.*;
import java.net.Socket;

@Parameters(separators = "=")
public class Main {

    @Parameter(names = "--server-port")
    private static Integer port;

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        Main.setPort(args);
        try {
            clientSocket = new Socket("localhost", port);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            System.out.print(in.readLine());
            System.out.print("\n> ");
            out.write(reader.readLine() + "\n");
            out.flush();
            while (true) {
                String str = in.readLine();
                if (str.equals("Successful!")) {
                    System.out.println(str);
                    clientSocket.close();
                    in.close();
                    out.close();
                    System.exit(0);
                }
                else if (str.equals("Bad connect!"))
                {
                    clientSocket.close();
                    in.close();
                    out.close();
                    System.exit(0);
                }
                else
                {
                    System.out.println(str);
                    System.out.print("> ");
                    out.write(reader.readLine() + "\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static public void setPort(String[] args) {
        Main main = new Main();

        JCommander.
                newBuilder().
                addObject(main).
                build().
                parse(args);
    }
}
