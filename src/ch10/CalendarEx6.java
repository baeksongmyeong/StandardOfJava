package ch10;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx6 {

    public static void main(String[] args) {
        // 화면에서 입력을 받을 준비를 한다.
        Scanner sc = new Scanner(System.in);

        int START_DAY_OF_WEEK = 0;
        int END_DAY = 0;

        while (true) {

            // 입력요청 메시지를 보여준다.
            System.out.print("#입력요청 >> ");

            // 화면에서 입력을 받는다.
            String[] sArr = sc.nextLine().split(" ");

            // q 가 입력되면 종료한다.
            if("q".equals(sArr[0])) System.exit(0);

            // 입력된 문자가 2개인지 확인한다.
            if(2 != sArr.length){
                System.out.println("년도와 월을 입력하세요. 2개 입력 필요");
                continue;
            }

            int year = 0;
            int month = 0;

            // 첫번째 문자가 4자리 숫자인지 확인한다.
            try{
                year = Integer.parseInt(sArr[0]);
            } catch (Exception e){
                System.out.println("년도를 숫자로 입력하세요");
                continue;
            }

            // 두번째 문자가 1 ~ 12 사이의 숫자인지 확인한다.
            try{
                month = Integer.parseInt(sArr[1]);
            } catch (Exception e){
                System.out.println("월을 숫자로 입력하세요");
                continue;
            }

            if( 1 > month || 12 < month ){
                System.out.println("1 부터 12 사이의 월을 입력하세요");
                continue;
            }

            // Calendar 인스턴스 생성
            Calendar sDay = Calendar.getInstance(); // 시작일
            Calendar eDay = Calendar.getInstance(); // 끝일

            // 입력된 년도와 월을 설정
            sDay.set(year, month-1, 1); // 시작일
            eDay.set(year, month, 1);
            eDay.add(Calendar.DATE, -1); // 끝일

            // 시작일의 요일 확인 ( 1 부터 시작. 일요일 )
            START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

            // 끝일의 요일 확인
            END_DAY = eDay.get(Calendar.DATE);

            System.out.println("    " + year + "년 " + month + "월");
            System.out.println(" SU MO TU WE TH FR SA");

            // 시작일의 요일보다 앞서는 요일은 공백으로 바꾼다.
            for (int i = 1; i < START_DAY_OF_WEEK; i++) {
                System.out.print("   ");
            }

            for (int i = 1, n=START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
                System.out.print((i < 10) ? "  " + i : " " + i);

                // 한주가 지나면 개행한다.
                if(n%7==0) System.out.println();
            }

            System.out.println();

        }
    }
}
