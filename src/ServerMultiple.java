import java.io.*;
import java.net.*;
import java.util.*;
public class ServerMultiple {
     static  int PORT = 12345;
     static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendToAll(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            // Send the message to all clients except the sender
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}

class ClientHandler implements Runnable {
     Socket cSocket;
     PrintWriter out;

     ClientHandler(Socket clientSocket) {
        this.cSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            out = new PrintWriter(cSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from " + cSocket.getInetAddress() + ": " + message);
                ServerMultiple.sendToAll("Client: " + message, this);
            }

            System.out.println("Client disconnected.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                cSocket.close();
                ServerMultiple.removeClient(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
