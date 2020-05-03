package lesson6.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Socket socket;
    private static boolean isRunning = false;

    private static void serverRunRadWriht() throws IOException {
        server = new ServerSocket(80);
        System.out.println("Сервер запущен...");
        isRunning = true;
        socket = server.accept();
        System.out.println("Попключён клиент с адресом: " + socket.getInetAddress());
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Scanner input = new Scanner(System.in);

        Thread threadIn = new Thread(() -> {
            try {
                while (isRunning) {
                    String clientMes = in.readUTF();
                    if (clientMes.equalsIgnoreCase("закрыть")) {
                        System.out.println("Клиент отключился");
                        input.useDelimiter("d");
                        isRunning = false;
                        break;
                    }
                    System.out.println("Сообщение от клиета: " + clientMes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread threadOut = new Thread(() -> {

            try {
                while (isRunning) {
                    String outMes = input.nextLine();
                    out.writeUTF(outMes);
                    out.flush();
                    if (outMes.equalsIgnoreCase("закрыть")) {
                        isRunning = false;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadIn.start();
        threadOut.start();
    }

    public static void main(String[] args) throws IOException {
        serverRunRadWriht();
    }
}
