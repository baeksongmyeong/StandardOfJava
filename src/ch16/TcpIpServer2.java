package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println(getTime() + "연결요청을 기다립니다.");
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
                
                // 상대편 소켓의 포트번호
                System.out.println("getPort() : " + socket.getPort());
                
                // 내 소켓의 포트번호
                System.out.println("getLocalPort() : " + socket.getLocalPort());

                // 상대편 소켓에 데이터를 보낸다.
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(outputStream);
                dos.writeUTF("[Notice] Test Message1 from Server.");

                // 출력 스트림 종료
                dos.close();

                // 생성된 소켓 종료
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getTime() {
        return new SimpleDateFormat("[hh:mm:ss]").format(new Date());
    }
}
