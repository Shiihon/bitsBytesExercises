package SocketProgramming;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1"; // local port nummer vi bruger til at forbinde til egen maskine.
    private static final int PORT = 9090;
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket(SERVER_IP, PORT);
        BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //bufferedReader er det modsatte af PrintWriter, tager mod en strøm af bytes, buffered reader læser blokke af gangen. Som kan læses fra.
        String messageFromServer = inputFromServer.readLine();
        System.out.println("Fra server: " + messageFromServer);

        clientSocket.close();
    }
}
