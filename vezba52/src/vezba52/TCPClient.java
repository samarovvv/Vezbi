//Да се напише TCP клиент и сервер апликација во која клиентот му испраќа порака на серверот.
//Серверот врши конвертирање на сите мали букви во големи и ја враќа конвертираната порака
//до клиентот.


package vezba52;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int SERVER_PORT = 12345;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Поврзан со серверот " + SERVER_IP + ":" + SERVER_PORT);

            // Внесување на порака од страна на клиентот
            System.out.print("Внесете порака: ");
            String message = scanner.nextLine();

            // Прати порака до серверот
            out.println(message);

            // Прими и прикажи го конвертираниот одговор од серверот
            String serverResponse = in.readLine();
            System.out.println("Одговор од сервер: " + serverResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}