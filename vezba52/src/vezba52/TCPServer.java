package vezba52;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Серверот е подготвен за слушање на порта " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Клиентот се поврза: " + clientSocket.getInetAddress());

                    // Читање порака од клиентот
                    String clientMessage = in.readLine();
                    System.out.println("Примена порака од клиент: " + clientMessage);

                    // Конверзија на сите мали букви во големи и праќање на резултатот до клиентот
                    String convertedMessage = clientMessage.toUpperCase();
                    out.println("Сервер: " + convertedMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}