package ch15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) throws IOException {

        // 원천 파일
        String fileName = "test.txt";
        
        // 바이트 기반 파일 입력 스트림
        FileInputStream fis = new FileInputStream(fileName);
        
        // 문자 기반 파일 리더
        FileReader fr = new FileReader(fileName);

        int data = 0;

        // 바이트 기반 파일 입력 스트림을 이용해서 파일 내 문자를 읽어서 출력해본다.
        // 영문은 출력이 정상이지만, 한글은 깨져서 나온다.
        while ( (data = fis.read()) != -1) {
            System.out.println(data + " >> " + (char)data);
        }

        System.out.println();

        // 스트림 종료
        fis.close();

        // 문자 기반 파일 리더를 이용해서 파일 내 문자를 읽어서 출력해본다.
        // 영문, 한글 모두 출력이 정상이다.
        while ( (data = fr.read()) != -1) {
            System.out.println(data + " >> " + (char)data);
        }

        // 스트림 종료
        fr.close();
    }
}
