package ch10;

import java.text.MessageFormat;
import java.text.ParseException;

public class MessageFormatEx3 {
    public static void main(String[] args) {

        // 패턴이 이미 적용된 문자열
        String[] data = {
                "INSERT INTO CUST_INFO VALUES ('이자바','02-123-1234','27','07-09');"
                , "INSERT INTO CUST_INFO VALUES ('김프로','032-543-1234','41','57-01');"
        };

        // 패턴 생성
        String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";

        // MessageFormater 생성
        MessageFormat mf = new MessageFormat(pattern); // 파싱을 위해서는 인스턴스가 필요

        for (int i = 0; i < data.length; i++) {
            try {
                Object[] objs = mf.parse(data[i]);
                for (Object obj : objs) {
                    System.out.print(obj + ", ");
                }
                System.out.println();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        


    }
}

