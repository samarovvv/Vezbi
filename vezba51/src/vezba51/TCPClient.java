//Да се напише TCP клиент и сервер апликација во која клиентот на серверот му испраќа
//порака внесена преку тастатура, а серверот ја враќа на клиентот и ја печати на екран.
//Доколку испратената порака е со содржина KRAJ се затвора сокетот на страна на серверот за
//крај на врската.


package vezba51;

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

            while (true) {
                System.out.print("Внесете порака (KRAJ за крај): ");
                String message = scanner.nextLine();

                // Шалемска проверка за завршување на комуникацијата
                if (message.equals("KRAJ")) {
                    out.println(message);
                    break;
                }

                // Шалемско праќање на пораката до серверот
                out.println(message);

                // Примање и прикажување на одговорот од серверот
                String serverResponse = in.readLine();
                System.out.println("Одговор од сервер: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}