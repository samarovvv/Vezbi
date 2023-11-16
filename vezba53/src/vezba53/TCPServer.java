package vezba53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

                    // Читање на e-mail адресата од клиентот
                    String clientEmail = in.readLine();
                    System.out.println("Примена e-mail адреса од клиент: " + clientEmail);

                    // Проверка на валидноста на e-mail адресата
                    if (isValidEmail(clientEmail)) {
                        out.println("OK");
                        System.out.println("Валидна e-mail адреса. Испратен 'OK' до клиентот.");
                    } else {
                        out.println("NO");
                        System.out.println("Невалидна e-mail адреса. Испратен 'NO' до клиентот.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidEmail(String email) {
        // Стандардна регуларна израз за валидација на e-mail адреса
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
