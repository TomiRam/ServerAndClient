import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost, port 12345S
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            // Set up input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            out.println("Hello from the client!");

            // Read the server's response and print it
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

            // Close the streams and socket
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}