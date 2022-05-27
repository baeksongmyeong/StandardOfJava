package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx2 {
    public static void main(String[] args) {
        
        // 입력용, 출력용, 읽기용 바이트 배열 생성
        byte[] inSrc = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        // 입력 스트림 생성
        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        
        // 출력 스트림 생성
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        // 입력 스트림으로부터 읽기용 바이트 배열 크기만큼의 데이터를 한번에 읽어옴
        input.read(temp, 0, temp.length); // 입력 스트림의 시작부터 읽되, temp 의 길이만큼 읽는다. 그리고, temp 의 0 번째부터 저장한다.
        output.write(temp, 5, 5);

        // 출력 스트림을 바이트 배열로 변환
        outSrc = output.toByteArray();

        // 출력
        System.out.println(Arrays.toString(inSrc));
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(outSrc));


    }
}
