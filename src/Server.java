import java.util.*;
import java.io.*;
import java.net.*;
public class Server {
    ServerSocket socket;

    Server(ServerSocket socket){
        this.socket = socket;
    }


    public void start(){
        try{
            while(!socket.isClosed()){
                System.out.println("Server started, waiting for client to connect!");
                Socket s = socket.accept();
            }
        } catch (IOException e) {

        }
    }
}
