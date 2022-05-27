package ch15;

import java.io.*;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) throws IOException {

        // 기반 스트림 생성
        FileOutputStream fos = new FileOutputStream("123.txt");

        // 보조 스트림 생성
        BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
        
        // 파일에 1 부터 9 까지 출력
        for (int i = '1'; i <= '9'; i++) {
            bos.write(i);
        }

        bos.close();
    }
}
