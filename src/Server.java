import java.util.*;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        int port = 8888;
        try{
            //create a server
            ServerSocket socket = new ServerSocket(port);
            System.out.println("Server started, waiting for client connection...");

            //client connected
            Socket cSocket = socket.accept();
            System.out.println("Client connected!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
