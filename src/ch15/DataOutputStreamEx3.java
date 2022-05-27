package ch15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx3 {
    
    public static void main(String[] args) {

        // 원천 값 int 배열
        int[] scores = {100, 90, 95, 85, 50};

        try {
            // 바이트 기반 스트림 중 파일 출력 스트림 생성
            FileOutputStream fis = new FileOutputStream("score.dat");

            // 바이트 보조 스트림 중 기본형 출력 스트림 생성
            DataOutputStream dos = new DataOutputStream(fis);

            // 원천값을 스트림에 write
            for(int score : scores ){
                dos.writeInt(score);
            }

            // 보조 스트림 닫기 ( 기반 스트림도 자동을 닫힌다. )
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
