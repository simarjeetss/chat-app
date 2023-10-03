import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        int port = 8888;
        try{

            //create a server socket to listen for incoming client connection
            ServerSocket ssocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for client connection...");

            //accept connection from client1
            Socket csocket1 = ssocket.accept();
            System.out.println("Client 1 connected");

            //create input and output streams-> client-1
            BufferedReader in1 = new BufferedReader(new InputStreamReader(csocket1.getInputStream()));
            PrintWriter out1 = new PrintWriter(csocket1.getOutputStream());

            //accept the second client connection
            Socket csocket2 = ssocket.accept();
            System.out.println("Client 2 connected");

            //create input and output streams-> client 2
            BufferedReader in2 = new BufferedReader(new InputStreamReader(csocket2.getInputStream()));
            PrintWriter out2 = new PrintWriter(csocket2.getOutputStream());


            //creating threads to handle messages from both clients
            Thread c1thread = new Thread(new ClientHandler(in1,out2));
            Thread c2thread = new Thread(new ClientHandler(in2,out1));

            c1thread.start();
            c2thread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ClientHandler implements Runnable{
    BufferedReader in;
    PrintWriter out;

    ClientHandler(BufferedReader in, PrintWriter out){
        this.in = in;
        this.out = out;
    }

    public void run(){
        String message;
        try{
            while((message = in.readLine()) != null){
                System.out.println("Received: " + message);
                out.println("You said: " + message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
