package ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("입력/출력 파일명 입력 필수");
            System.exit(0);
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(args[0]);
            fos = new FileOutputStream(args[1], true); // 파일 출력 스트림은 파일이 없는 경우, 파일을 생성한다.

            int data = 0;

            while ( (data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
