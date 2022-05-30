package ch15;

import java.io.*;
import java.util.ArrayList;

/*
* 객체 -> 직렬화
* */
public class SerialEx1 {
    public static void main(String[] args) {

        try {
            // 객체 직렬화 결과 저장 파일명
            String fileName = "UserInfo.ser";

            // 파일 기반 스트림
            FileOutputStream fos = new FileOutputStream(fileName);

            // 보조 스트림
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            // 직렬화 스트림
            ObjectOutputStream out = new ObjectOutputStream(bos);

            // 객체 생성
            UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
            UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);

            // 리스트에 객체 추가
            ArrayList<UserInfo> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);
            
            // 객체 직렬화
            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);

            // 스트림 종료
            out.close();

            System.out.println("직렬화 종료");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
