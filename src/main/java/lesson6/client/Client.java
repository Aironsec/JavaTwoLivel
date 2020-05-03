package lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String ADRES = "127.0.0.1";
    private static final int PORT = 80;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Socket socket = null;
    private static boolean isRunning = false;

    private static void openConnectReadWrihtMes() throws IOException{
        socket = new Socket(ADRES, PORT);
        isRunning = true;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Scanner input = new Scanner(System.in);
        Thread threadIn = new Thread(() -> {
            try {
                while (isRunning) {
                    String mesFromServer = in.readUTF();
                    if (mesFromServer.equalsIgnoreCase("закрыть")) {
                        System.out.println("Сервер отключился");
                        input.close();
                        isRunning = false;
                        break;
                    }
                    System.out.println("Сообщение от сервера: " + mesFromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread threadOut = new Thread(() -> {

            try {
                while (isRunning) {
                    String mesToServer = input.nextLine();
                    out.writeUTF(mesToServer);
                    out.flush();
                    if (mesToServer.equalsIgnoreCase("закрыть")) {
                        isRunning =false;
                        break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        threadOut.start();
        threadIn.start();

    }

    public static void main(String[] args) throws IOException {
        openConnectReadWrihtMes();
    }
}
