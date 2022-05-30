package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer3 {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        // 7777 포트로 서버 소켓 생성
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(getTime() + "연결요청을 기다립니다.");

            // 서버소켓 요청대기시간 5초로 설정
            serverSocket.setSoTimeout(5 * 1000);

            new Date();

            // 요청대기 및 요청수신시 신규 소켓 생성
            Socket socket = serverSocket.accept();

            // 원격 소켓 정보 출력
            System.out.println(getTime() + socket.getInetAddress() + " : " + socket.getPort() + "로부터 연결요청이 들어왔습니다.");

            // 원격 소켓에 데이터 전송
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("[Notice] Test Message1 from Server.");
            System.out.println(getTime() + "데이터를 전송했습니다.");

            // 출력스트림 종료
            dos.close();

            // 소켓 종료
            socket.close();

            System.out.println(getTime() + "소켓을 종료했습니다.");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) { // 요청대기시간 초과시 예외발생
            System.out.println("지정된 시간동안 접속요청이 없어서 서버를 종료합니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTime() {
        return new SimpleDateFormat("[hh:mm:ss]").format(new Date());
    }
}
