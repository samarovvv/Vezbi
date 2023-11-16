//Да се напише TCP клиент и сервер апликација во која клиентот испраќа е-mail адреса до
//серверот. Серверот треба да утврди дали станува збор за валидна e-mail адреса. Во тој случај му
//испраќа порака со текст “OK” на клиентот. Доколку адресата не е валидна му испраќа порака со
//текст “NO”.



package vezba53;

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

            // Внесување на e-mail адресата од страна на клиентот
            System.out.print("Внесете e-mail адреса: ");
            String email = scanner.nextLine();

            // Прати e-mail адреса до серверот
            out.println(email);

            // Прими и прикажи го одговорот од серверот
            String serverResponse = in.readLine();
            System.out.println("Одговор од сервер: " + serverResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
