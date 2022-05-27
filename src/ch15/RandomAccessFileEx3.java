package ch15;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx3 {
    public static void main(String[] args) {
        int sum = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");

            int i = 4;
            int score = 0;

            while (true) {

                raf.seek(i); // 포인터 이동
                System.out.println(raf.getFilePointer());
                score = raf.readInt(); // 국어 점수
                System.out.println("국어점수 : " + score);
                sum += score;
                i += 16; // 영어, 수학, 번호 skip
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (EOFException e) {
            System.out.println("EOFException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
