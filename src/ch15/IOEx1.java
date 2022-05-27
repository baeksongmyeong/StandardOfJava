package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
* 입력 소스 -> 입력 스트림(입력소스) -> 입력 스트림.read()
* 출력 소스 -> 출력 소스.write(값)
* */
public class IOEx1 {
    public static void main(String[] args) {
        
        // 입력 byte 배열
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // inputStream 생성
        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);

        // outputStream 생성
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        // 입력 스트림을 1바이트씩 읽음
        while ((data = input.read()) != -1) { // 읽을 데이터가 없으면 -1 을 리턴
            output.write(data); // 출력스트림에 1 바이트 추가
        }

        // 출력 byte 배열
        byte[] outSrc = null;

        // 출력 스트림을 바이트 배열로 변환
        outSrc = output.toByteArray();

        // 입력과 출력을 출력
        System.out.println(Arrays.toString(inSrc));
        System.out.println(Arrays.toString(outSrc));
    }
}
