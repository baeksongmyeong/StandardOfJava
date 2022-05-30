package ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

//--------------------------------------
// 메인 클래스
//--------------------------------------
public class TcpIpMultichatServer {

    // 인스턴스 참조변수
    HashMap<String, DataOutputStream> clients;

    //--------------------------------------
    // 생성자
    //--------------------------------------
    public TcpIpMultichatServer() {
        clients = new HashMap();
        Collections.synchronizedMap(clients); // 컬렉션 동기화(Lock)
    }

    //--------------------------------------
    // 메인 메서드
    //--------------------------------------
    public static void main(String[] args) {
        new TcpIpMultichatServer().start();
    }

    //--------------------------------------
    // 인스턴스 메서드 - 서버소켓 생성 및 요청 수신시 소켓을 생성, 쓰레드를 생성
    //--------------------------------------
    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server start");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // start()

    //--------------------------------------
    // 인스턴스 메서드 - 등록된 모든 클라이언트에게 메시지 발송
    //--------------------------------------
    void sendToAll(String msg) {
        // 클라이언트 목록
        Iterator it = clients.keySet().iterator();
        
        // 클라이언트 전체에 메시지 전송
        while (it.hasNext()) {
            DataOutputStream out = clients.get(it.next());
            try {
                out.writeUTF(msg);
            } catch (IOException e) {e.printStackTrace();}
        }
    } // sendToAll()

    //--------------------------------------
    // 내부 클래스 - 수신용 쓰레드
    //--------------------------------------
    class ServerReceiver extends Thread {

        // 사용할 소켓 및 입/출력 스트림
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                // 소켓을 통해 데이터 받기
                in = new DataInputStream(socket.getInputStream());
                // 소켓을 통해 데이터 보내기
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {e.printStackTrace();}
        }

        @Override
        public void run() {
            String name = "";

            try {
                // 최초 쓰레드 구동
                name = in.readUTF();
                sendToAll("#" + name + " is comming.");
                
                // 접속자 key 값과 해당 소켓의 출력스트림 저장
                clients.put(name, out);
                System.out.println("User count : " + clients.size() );

                // 입력된 데이터가 있다면
                while (in != null) {
                    sendToAll(in.readUTF());
                }
            } catch (IOException e) {
                //e.printStackTrace();
            } finally {
                clients.remove(name);
                sendToAll("#" + name + " is out.");
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + " exit.");
                System.out.println("User count : " + clients.size() );
            }
        } // run
    } // ServerReceiver Inner Class
} // TcpIpMultichatServer Class



