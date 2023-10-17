<h1>Simple Java Socket Chat App</h1>

This is a simple Java Socket Chat Application that allows multiple clients to connect to a server and communicate with each other using text messages. This repository contains the source code for both the server and the client applications.

<h2>Server</h2>
Open the ServerMultiple.java file in your favorite Java IDE.
Modify the PORT if needed (default is 12312).
Run the ServerMultiple class.
The server will start, and it will listen for incoming client connections. You will see "Server started. Waiting for clients..." in the console.

Client
Open the Client.java file in your favorite Java IDE.
Ensure that the address is set to the IP address or hostname of the server, and the port matches the server's port (default is 12312).
Run the Client class.
The client application will connect to the server, and you will see "Server accepted the request" in the client's console.

Chatting
Once the client is connected to the server, you can start chatting:

Type your message in the client's console and press Enter to send it to the server.
The server will broadcast the message to all connected clients, and you will see messages from other clients in your client's console.
How It Works
The server listens for incoming connections on the specified port using a ServerSocket.
Each client is handled in a separate thread (ClientHandler) on the server.
The server broadcasts messages to all connected clients, except the sender.
The client connects to the server, reads and sends messages to the server using separate threads (ReadHandler for reading messages).
