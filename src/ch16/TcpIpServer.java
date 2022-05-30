package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
    public static void main(String[] args) {

        // 서버 소켓 참조변수
        ServerSocket serverSocket = null;

        try {
            // 서버소켓 인스턴스 생성 및 7777 번 포트에 바인딩
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " 서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                // 클라이언트로부터 연결요청이 올때까지 대기
                System.out.println(getTime() + " 연결요청을 기다립니다.");

                // 연결요청 수신
                // 자동으로 처리됨
                
                // 서버에 소켓이 신규로 생성됨
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + " " + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");

                // 소켓의 출력스트림 참조
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓에 데이터를 보낸다
                dos.writeUTF("[Notice] Test Message1 from Server.");
                System.out.println(getTime() + " 데이터를 전송했습니다.");

                // 출력 스트림 종료
                dos.close();

                // 소켓 종료
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
        return sdf.format(new Date());
    }
}
