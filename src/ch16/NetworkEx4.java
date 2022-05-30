package ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx4 {
    public static void main(String[] args) {
        URL url = null;
        BufferedReader input = null;
        String address = "https://finance.daum.net/investment/columns/7983?type=stock_market";
        String line = "";

        try {

            // URL 인스턴스 생성
            url = new URL(address);

            // URL 인스턴스의 InputStream 인스턴스 반환 ( URL Connection 없이 가능 )
            InputStream inputStream = url.openStream();

            // URL 인스턴스의 URL Connection 인스턴스를 통한 InputStream 인스턴스 반환
            //URLConnection conn = url.openConnection();
            //inputStream = conn.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            input = new BufferedReader(inputStreamReader);

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
