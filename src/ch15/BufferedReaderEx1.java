package ch15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx1 {
    public static void main(String[] args) {
        try {
            // 기반 스트림 생성
            FileReader fr = new FileReader("BufferedReaderEx1.txt");

            // 보조 스트림 생성
            BufferedReader br = new BufferedReader(fr);

            // 읽어들인 라인의 문자열
            String line = "";

            // 데이터를 읽어들임
            for (int i = 0; (line = br.readLine()) != null ; i++) {
                if (line.indexOf("Line") != -1) {
                    System.out.println(i + " : " + line);
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
