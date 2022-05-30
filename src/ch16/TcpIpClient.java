package ch16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            // 서버의 ip 와 port
            String serverIp = "127.0.0.1";
            int serverPort = 7777;

            // 소켓 생성 및 연결 요청
            Socket socket = new Socket(serverIp, serverPort);

            // 소켓의 입력스트림 참조
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 입력스트림 값 출력
            String data = dis.readUTF();
            System.out.println("서버로부터 받은 메시지 : " + data);
            System.out.println("연결을 종료합니다.");

            // 입력스트림 종료
            dis.close();

            // 소켓 종료
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
