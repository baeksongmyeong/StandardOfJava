package ch15;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx2 {
    public static void main(String[] args) {
        // 현재 점수
        int score = 0;

        // 점수 총합
        int sum = 0;

        /*
        * score.dat (writeInt() 로 입력되어 있는) 파일을 읽어서, 현재 점수를 출력하고, 총점에 더한다
        * 파일을 다 읽으면 EOFException 이 발생하므로, 이 예외가 발생시 총점을 출력한다.
        * */

        // 파일 입력 스트림 참조변수 생성
        FileInputStream fis = null;

        // 보조 스트림 참조변수 생성
        DataInputStream dis = null;

        // 파일을 읽어들여서 계산한다.
        try {
            fis = new FileInputStream("score.dat");
            dis = new DataInputStream(fis);

            while (true) {
                score = dis.readInt();
                System.out.println("score = " + score);
                sum += score;
            }
        } catch (EOFException e) {
            System.out.println("sum = " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
