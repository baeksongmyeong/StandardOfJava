package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

// 쓰레드로 생성할 수 있는 클래스
public class TcpIpServer4 implements Runnable {

    // 서버 소켓
    ServerSocket serverSocket;
    
    // 쓰레드 배열
    Thread[] threadArr;

    // 생성자
    // 입력된 수 만큼의 쓰레드 배열 생성
    public TcpIpServer4(int num) {
        try {
            // 서버소켓 생성 - 7777 포트
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다");
            
            // 쓰레드 배열의 인스턴스 생성
            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        
        // 생성자를 통해 생성된 쓰레드들을 가지고 있는 인스턴스
        TcpIpServer4 server = new TcpIpServer4(5);
        
        // 내부 메서드 호출 ( 각 쓰레드들을 실행 )
        server.start();
    }

    // 쓰레드 생성 및 실행
    public void start() {
        
        // 선언한 개수만큼 쓰레드 생성후 실행
        for (int i = 0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    // 쓰레드가 실행할 내용
    @Override
    public void run() {
        System.out.println(getTime() + "가 연결요청을 기다립니다.");
        try {
            // 연결 수신 및 소켓 생성
            Socket socket = serverSocket.accept();
            System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");

            // 원격 소켓에 데이터 전송
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("[Notice] Test Message1 from Server.");
            System.out.println(getTime() + "데이터를 전송했습니다.");

            // 출력스트림 및 소켓 종료
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTime() {
        String name = Thread.currentThread().getName();
        return new SimpleDateFormat("[hh:mm:ss]").format(new Date()) + name + " ";
    }
}
