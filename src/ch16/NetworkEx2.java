package ch16;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class NetworkEx2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.codechobo.com:80/sample/" + "hello.html?referer=codechobo#index1");
            url = new URL("https://www.inflearn.com/course/%EC%98%A4%ED%94%88%EC%86%8C%EC%8A%A4-%EB%A6%AC%EC%95%A1%ED%8A%B8-%EC%9E%85%EB%AC%B8-1/dashboard");
            
            // 호스트명과 포트명을 문자열로 반환
            System.out.println("url.getAuthority() : " + url.getAuthority());

            // URL 의 content 객체 반환
            System.out.println("url.getContent() : " + url.getContent());

            // URL 의 기본 포트 반환
            System.out.println("url.getDefaultPort() : " + url.getDefaultPort());

            // URL 의 포트 반환
            System.out.println("url.getPort() : " + url.getPort());

            System.out.println("url.getFile() :        " + url.getFile()       );
            System.out.println("url.getHost() :        " + url.getHost()       );
            System.out.println("url.getPath() :        " + url.getPath()       );
            System.out.println("url.getProtocol() :    " + url.getProtocol()   );
            System.out.println("url.getQuery() :       " + url.getQuery()      );
            System.out.println("url.getRef() :         " + url.getRef()        );
            System.out.println("url.getUserInfo() :    " + url.getUserInfo()   );
            System.out.println("url.toExternalForm() : " + url.toExternalForm());
            System.out.println("url.toURI() :          " + url.toURI()         );

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
