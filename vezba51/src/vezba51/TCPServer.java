package vezba51;

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

                    String clientMessage;
                    while ((clientMessage = in.readLine()) != null) {
                        System.out.println("Примена порака од клиент: " + clientMessage);

                        if (clientMessage.equals("KRAJ")) {
                            System.out.println("Клиентот испрати KRAJ. Затвараме врска.");
                            break;
                        }

                        // Одговор до клиентот
                        out.println("Сервер: " + clientMessage);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}