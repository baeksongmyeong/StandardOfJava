package ch10;

import java.time.Instant;
import java.util.Date;

/*
* Instant 는 에포크타입부터 경과된 시간을 나노초 단위로 표현
* 초와 나노초를 별도의 필드로 관리
* 나노초 : int
* 초 : long
* 
* Date 인스턴스로 변환이 가능
* Date.from(Instant 인스턴스)
* Date.toInstant()
* */
public class NewTimeEx1_1 {
    public static void main(String[] args) {

        // Instant 인스턴스 생성
        Instant now = Instant.now(); // 현재시간
        System.out.println("now = " + now);

        Instant instant1 = Instant.ofEpochSecond(now.getEpochSecond());
        System.out.println("instant1 = " + instant1);

        Instant instant2 = Instant.ofEpochSecond(now.getEpochSecond(), now.getNano());
        System.out.println("instant2 = " + instant2);

        // 초 가져오기
        long epochSecond = now.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);

        // 나노초 가져오기
        int nano = now.getNano();
        System.out.println("nano = " + nano);

        // 밀리초 가져오기
        long milli = now.toEpochMilli();
        System.out.println("milli = " + milli);

        // Date 로 변환
        Date date = Date.from(now);
        System.out.println("date = " + date);

        // Instant 로 변환
        Instant instant = date.toInstant();
        System.out.println("instant = " + instant);

    }
}
