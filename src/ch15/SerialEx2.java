package ch15;

/*
* 역직렬화 -> 객체
* */

import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {
    public static void main(String[] args) {
        // 직렬화 결과가 있는 파일
        String fileName = "UserInfo.ser";
        

        try {
            // 기반 스트림
            FileInputStream fis = new FileInputStream(fileName);
            // 보조 스트림
            BufferedInputStream bis = new BufferedInputStream(fis);
            // 역직렬화 스트림
            ObjectInputStream input = new ObjectInputStream(bis);

            UserInfo u1 = (UserInfo) input.readObject();
            UserInfo u2 = (UserInfo) input.readObject();
            ArrayList<UserInfo> list = (ArrayList<UserInfo>) input.readObject();

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);

            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
