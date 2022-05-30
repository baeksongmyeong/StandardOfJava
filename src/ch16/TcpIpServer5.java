package ch16;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer5 {
    public static void main(String[] args) {

        // 서버소켓 과 소켓 참조변수
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 7777 포트 서버소켓
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");

            // 서버소켓 대기 및 소켓 생성
            socket = serverSocket.accept();
            System.out.println("소켓이 생성되었습니다.");

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}