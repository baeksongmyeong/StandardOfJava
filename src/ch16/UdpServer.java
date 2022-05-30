package ch16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
    public static void main(String[] args) {
        try {
            new UdpServer().start();
        } catch (IOException e) {e.printStackTrace();}
    }

    public void start() throws IOException {

        // 데이터그램 소켓 생성
        DatagramSocket socket = new DatagramSocket(7777);

        // 입/출력 데이터그램 패킷 선언
        DatagramPacket inPacket;
        DatagramPacket outPacket;

        byte[] inMsg = new byte[100];
        byte[] outMsg = null;

        while (true) {
            // 데이터를 수신하기 위한 패킷 생성 ( 패킷은 저장공간이라고 이해하자 )
            inPacket = new DatagramPacket(inMsg, inMsg.length);

            // 수신된 데이터를 패킷에 저장
            socket.receive(inPacket);
            System.out.println(inPacket);
            System.out.println(inPacket.getData());
            System.out.println(inPacket.getData().toString());
            System.out.println(new String(inPacket.getData(), StandardCharsets.UTF_8));

            // 수신한 패킷으로부터 Client 의 ip, port 확인
            InetAddress address = inPacket.getAddress();
            int port = inPacket.getPort();

            // 서버의 현재시간을 시분초 형태로 만든후 byte 배열로 변환
            String time = new SimpleDateFormat("[hh:mm:ss]").format(new Date());
            outMsg = time.getBytes();

            // 패킷을 생성하여, Client 에게 전송
            outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
            socket.send(outPacket);
        }
    } // start()
}
