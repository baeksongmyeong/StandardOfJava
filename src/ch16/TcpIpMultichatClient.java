package ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpMultichatClient {

    public static void main(String[] args) {
        
        // 대화명 입력
        if (args.length != 1) {
            System.out.println("name input");
            System.exit(0);
        }

        // 서버 정보
        String serverIp = "127.0.0.1";
        int serverPort = 7777;
        Socket socket = null;

        try {
            // 소켓 연결
            socket = new Socket(serverIp, serverPort);
            System.out.println("Server connected");

            // 송신, 수신 쓰레드 생성 및 실행
            Thread sender   = new Thread(new ClientSender(socket, args[0]));
            Thread receiver = new Thread(new ClientReceiver(socket));
            sender.start();
            receiver.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // main()

    static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name = "";

        public ClientSender(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
            try {
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {e.printStackTrace();}
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                // 대화명을 서버로 전송 ( 아래 while 문이 있으므로, 소켓이 처음으로 연결된 시점에만 이름이 서버로 전송됨 )
                if (out != null) { // 소켓연결이 되어있는동안이라면
                    out.writeUTF(name);
                }

                // 입력하는 문자를 서버로 전송
                while (out != null) { // 소켓연결이 되어있는동안이라면
                    out.writeUTF("[" + name + "]" + scanner.nextLine());
                }
            } catch (IOException e) {e.printStackTrace();}
        }
    } // ClientSender

    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {e.printStackTrace();}
        }

        @Override
        public void run() {
            while (in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {e.printStackTrace();}
            }
        }
    }


}
