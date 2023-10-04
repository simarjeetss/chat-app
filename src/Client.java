import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 12312;

        try{
            //connecting the server
            Socket socket = new Socket(address, port);
            System.out.println("Server accepted the request");

            //create input and output stream for communication with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //reading messages from the server
            Thread read = new Thread(new ReadHandler(in));
            read.start();

            //reading user input and sending messages to the server
            Scanner sc = new Scanner(System.in);
            String message;

            while(true){
                message = sc.nextLine();
                out.println(message);
            }

        } catch (IOException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}

class ReadHandler implements Runnable{
    BufferedReader in;

    ReadHandler(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run(){
        String message;
        try{
            while((message = in.readLine()) != null){
                System.out.println(message);

            }
        } catch (IOException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
