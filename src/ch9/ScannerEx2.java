package ch9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* 파일로부터 한라인씩 읽어서 처리하는 예제
* */
public class ScannerEx2 {
    public static void main(String[] args) {

        int sum = 0;
        int cnt = 0;

        try {
            Scanner s = new Scanner(new File("data2.txt"));

            while (s.hasNextInt()){
                sum += s.nextInt();
                cnt++;
            }

            System.out.println("sum = " + sum);
            System.out.println("cnt = " + cnt);
            System.out.println("avg = " + (sum / (double)cnt));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
