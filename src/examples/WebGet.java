import java.io.*;
import java.net.Socket;
import java.util.*;

public class WebGet {
    public static void main(String[] args) throws IOException {
        String host;
        String resource;

        if(args.length == 2){
            host = args[0];
            resource = args[1];
        }else{
            System.out.println("Getting / from horstmann.com");
            host = "horstmann.com";
            resource = "/";
        }

        //opening the socket
        final int HTTP_PORT = 80;
        try(Socket s = new Socket(host,HTTP_PORT)){
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            Scanner in = new Scanner(is);
            PrintWriter out = new PrintWriter(os);

            String command = "GET " + resource + " HTTP/1.1\r\n" + "Host: " + host + "\r\n\r\n";

            out.println(command);
            out.flush();

            while(in.hasNextLine()){
                String input = in.nextLine();
                System.out.println(input);
            }
        }
    }
}
