package ch16;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UdpClient {
    public static void main(String[] args) {
        try {
            new UdpClient().start();
        } catch (IOException e) {e.printStackTrace();}
    }

    public void start() throws IOException {

        // 데이터그램 소켓 생성
        DatagramSocket datagramSocket = new DatagramSocket();

        // 데이터그램 패킷을 전송할 대상의 주소
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        // 전송할 데이터
        byte[] msg = new byte[100];
        msg = "abc".getBytes(StandardCharsets.UTF_8);

        // 입/출력 데이터그램 패킷 생성
        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777); // 비어있는 메시지 전송
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        // 데이터그램 패킷 전송
        datagramSocket.send(outPacket);
        
        // 데이터그램 패킷 수신
        datagramSocket.receive(inPacket);

        System.out.println("current server time : " + new String(inPacket.getData()));

        // 데이터그램 소켓 종료
        datagramSocket.close();
    }
}
