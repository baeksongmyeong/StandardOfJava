package ch16;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkEx1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        /*-------------------------------------------
        네이버
        -------------------------------------------*/
        try {
            // 도메인을 이용해서 ip 주소를 반환
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("ip = " + ip);

            // ip 주소의 호스트 이름을 반환
            String hostName = ip.getHostName();
            System.out.println("hostName = " + hostName);

            // ip 주소의 호스트 주소를 반환
            String hostAddress = ip.getHostAddress();
            System.out.println("hostAddress = " + hostAddress);

            // ip 주소를 byte 배열로 반환
            byte[] ipAddr = ip.getAddress();
            System.out.println("ipAddr = " + Arrays.toString(ipAddr));

            // ip 주소를 byte 배열로 만든 것의 각 요소에 256 을 더하면 호스트 주소가 반환됨
            String result = "";
            for (byte b : ipAddr) {
                result += b < 0 ? b + 256 : b;
                result += ".";
            }
            System.out.println("ip 주소 -> byte 배열 + 256 = " + result);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println();

        /*-------------------------------------------
        로컬
        -------------------------------------------*/
        try {
            // 로컬 pc 의 ip 주소를 반환
            ip = InetAddress.getLocalHost();
            System.out.println("ip = " + ip);
            String hostName = ip.getHostName();
            System.out.println("hostName = " + hostName);
            String hostAddress = ip.getHostAddress();
            System.out.println("hostAddress = " + hostAddress);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println();

        /*-------------------------------------------
        네이버
        -------------------------------------------*/
        try {
            // 도메인명에 지정된 모든 호스트의 ip 주소를 배열로 반환
            ipArr = InetAddress.getAllByName("www.naver.com");
            for (InetAddress addr : ipArr) {
                System.out.println("addr = " + addr);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
