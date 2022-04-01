package Server;

import Config.Config;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private ServerSocket serverUp() throws IOException {
        ServerSocket ss = new ServerSocket(Config.getPort());

        System.out.println("Server on port " + Config.getPort());

        return ss;
    }

    private Socket clientConnected(ServerSocket ss) throws IOException {
        Socket s = ss.accept();
        System.out.println("Client " + s.getPort() + " connected");

        return s;
    }

    private void sendCommands(Socket s) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        boolean exe = true;

        do {
            System.out.print("\nWrite a command: ");
            command = scanner.nextLine();

            if(command.equals("CloseConnection")) {
                exe = false;
            } else {
                PrintWriter pr = new PrintWriter(s.getOutputStream());
                pr.println(command);
                pr.flush();

                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String str = "";

                while ((str = bf.readLine ()) != null) {
                    System.out.println (str);
                    if(str.isEmpty() || str.isBlank()) break;
                }
            }

        } while (exe);
    }

    public void start() throws IOException {
        ServerSocket ss = serverUp();
        Socket s = clientConnected(ss);

        sendCommands(s);
    }
}
