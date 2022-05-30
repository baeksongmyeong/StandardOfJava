package ch16;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NetworkEx3 {
    public static void main(String[] args) {
        URL url = null;
        String address = "https://finance.daum.net/investment/columns/7983?type=stock_market";

        try {

            /*--------------------------------------
            1. URL 인스턴스 얻기
            ---------------------------------------*/
            // URL 주소로 URL 인스턴스 생성
            url = new URL(address);
            System.out.println("url = " + url);

            System.out.println(url.getProtocol());
            System.out.println(url.getHost() );
            System.out.println(url.getPath() );
            System.out.println(url.getFile() );
            System.out.println(url.getQuery());
            System.out.println(url.getRef()  );


            /*--------------------------------------
            2. URL 인스턴스의 URL Connection 인스턴스 얻기
            ---------------------------------------*/
            URLConnection conn = url.openConnection();
            System.out.println("conn = " + conn);

            /*--------------------------------------
            3. URL Connection 인스턴스의 메서드 호출
            ---------------------------------------*/
            boolean allowUserInteraction = conn.getAllowUserInteraction();
            System.out.println("allowUserInteraction = " + allowUserInteraction);

            int connectTimeout = conn.getConnectTimeout();
            System.out.println("connectTimeout = " + connectTimeout);

            Object content = conn.getContent();
            System.out.println("content = " + content);

            String contentEncoding = conn.getContentEncoding();
            System.out.println("contentEncoding = " + contentEncoding);

            int contentLength = conn.getContentLength();
            System.out.println("contentLength = " + contentLength);

            String contentType = conn.getContentType();
            System.out.println("contentType = " + contentType);

            long date = conn.getDate();
            System.out.println("date = " + date);

            Date date1 = new Date(date);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date1));

            boolean defaultUseCaches = conn.getDefaultUseCaches();
            System.out.println("defaultUseCaches = " + defaultUseCaches);

            boolean doInput = conn.getDoInput();
            System.out.println("doInput = " + doInput);

            boolean doOutput = conn.getDoOutput();
            System.out.println("doOutput = " + doOutput);

            long expiration = conn.getExpiration();
            System.out.println("expiration = " + expiration);

            Map<String, List<String>> headerFields = conn.getHeaderFields();
            System.out.println("headerFields = " + headerFields);

            long ifModifiedSince = conn.getIfModifiedSince();
            System.out.println("ifModifiedSince = " + ifModifiedSince);

            long lastModified = conn.getLastModified();
            System.out.println("lastModified = " + lastModified);

            int readTimeout = conn.getReadTimeout();
            System.out.println("readTimeout = " + readTimeout);

            URL url1 = conn.getURL();
            System.out.println("url1 = " + url1);

            boolean useCaches = conn.getUseCaches();
            System.out.println("useCaches = " + useCaches);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
