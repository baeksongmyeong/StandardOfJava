package ch15;

import java.io.*;

public class InputStreamReaderEx {
    public static void main(String[] args) {
        String line = "";

        /*
        * 화면 -> 입력 기반스트림 System.in -> 입력 보조스트림 InputStreamReader -> 입력 보조스트림 BufferedReader
        * */

        // 화면으로부터의 입력 스트림
        InputStream in = System.in;

        // 보조스트림 생성
        InputStreamReader isr = new InputStreamReader(in);

        // 보조스트림 생성
        BufferedReader br = new BufferedReader(isr);

        System.out.println("사용중인 OS 의 인코딩 : " + isr.getEncoding());

        // q 가 나오면 종료. 그 전까지는 입력한 라인값을 출력
        do {
            System.out.print("문장을 입력하세요 >> ");
            try {
                line = br.readLine();
                System.out.println("입력하신 문자 : " + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!line.equalsIgnoreCase("q"));

        System.out.println("프로그램을 종료합니다.");
    }
}
