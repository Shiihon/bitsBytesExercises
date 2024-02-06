package SocketProgramming;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class DateServer {
    private static final int PORT = 9090;
   public static void main(String[] args) throws IOException {

       ServerSocket serverSocket = new ServerSocket(PORT);
       System.out.println("Waiting for client.....");
       Socket clientSocket = serverSocket.accept(); // jeg vil gerne lave et objekt der kan kommunikere med client.
       System.out.println("Client has connected.....");

       PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
       // printwriter gør at man kan arbejde med et helt string og smide den igennem nettet.
       // clientSocket - skriver byte arrays, når man smider det ind i printWriter så kommer det ud som tekst.

       outputToClient.println("Today is: " + LocalDateTime.now().toString());

       System.out.println("Date is sent to client.....");
       System.out.println("Closing down server..... bye!");

       // lukker ned for det hele.
       clientSocket.close();
       serverSocket.close();

   }
}
