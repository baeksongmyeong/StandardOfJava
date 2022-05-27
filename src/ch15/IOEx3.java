package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {
    public static void main(String[] args) {

        /*
        * inSrc 10바이트 -> new ByteArrayInputStream(inSrc) -> ByteArrayInputStream.read(temp) -> temp 4바이트 -> ByteArrayOutput.write(temp)
        * read() 는 InputStream 의 버퍼를 읽어서 그 값을 반환한다. (읽고)
        * read(byte[] b) 는 InputStream 의 버퍼를 읽어서 대상에 쓰는 기능까지 제공한다. (읽고 쓰고)
        * write(byte[] b) 는 원본 바이트 배열을 읽어서 OutputStream 내 byte[] 에 쓰는 기능이다. (읽고 쓰고)
        * */

        // 입력 바이트 배열
        byte[] inSrc = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        // 입력 바이트 스트림
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inSrc);

        // 임시 바이트 배열
        byte[] temp = new byte[4];

        // 출력 바이트 스트림
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // 결과 바이트 배열
        byte[] outSrc = null;

        // 입력 바이트 스트림에 읽어들일 요소가 있을때까지 반복
        // 입력 바이트 스트림 -> 임시 바이트 배열 -> 출력 바이트 스트림 -> 결과 바이트 배열
        try {
            while (inputStream.available() > 0) {
                int len = inputStream.read(temp);
                outputStream.write(temp, 0, len);
                outSrc = outputStream.toByteArray();
                printArrays(temp, outSrc);
            }
        } catch (IOException e) {

        }
    }

    static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(outSrc));
    }
}
