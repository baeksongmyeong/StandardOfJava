package ch15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileViewer {
    public static void main(String[] args) throws IOException {
        
        // 파일 입력 스트림 생성
        FileInputStream fis = new FileInputStream(args[0]);

        // 파일의 한 문자를 참조할 변수
        int data = 0;

        // 파일 입력 스트림 읽기
        while ((data = fis.read()) != -1) {
            char c = (char) data;
            System.out.print(c);
        }
    }
}
