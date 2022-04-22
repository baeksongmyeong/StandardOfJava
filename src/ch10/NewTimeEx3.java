package ch10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;


/*
* TemporalAdjusters : 자주하는 날짜 계산을 미리 만들어놓은 메서드들을 가지는 클래스
*                     기능에 따른 열거형이 정의되어 있으며, 각 열거형은 TemporalAdjuster 의 구현체를 리턴한다.
* 
* TemporalAdjuster  : 날짜와 시간을 다루는 클래스에서 사용되는 클래스
* adjustInfo ()     : TemporalAdjuster 의 구현체가 사용되면 호출되는 메서드
* */
public class NewTimeEx3 {
    public static void main(String[] args) {
        // LocalDate 생성
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);

        // TemporalAdjuster 를 구현한 사용자 인스턴스 생성
        DayAfterTomorrow dayAfterTomorrow = new DayAfterTomorrow();
        
        // TemporalAdjuster 를 구현한 사용자 인스턴스에 LocalDate 인스턴스 적용
        // 그러면 오버라이드된 adjustInto 메서드가 실행됨
        LocalDate date = today.with(dayAfterTomorrow);
        System.out.println("date = " + date);

        // 다음달의 첫날
        TemporalAdjuster taj1 = TemporalAdjusters.firstDayOfNextMonth();
        LocalDate firstDayOfNextMonth = today.with(taj1);
        System.out.println("firstDayOfNextMonth = " + firstDayOfNextMonth);

        // 이달의 첫날
        TemporalAdjuster taj2 = TemporalAdjusters.firstDayOfMonth();
        LocalDate firstDayOfMonth = today.with(taj2);
        System.out.println("firstDayOfMonth = " + firstDayOfMonth);

        // 이달의 마지막 날
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));

        // 이달의 첫번째 화요일
        DayOfWeek dow = DayOfWeek.TUESDAY;
        TemporalAdjuster taj3 = TemporalAdjusters.firstInMonth(dow);
        System.out.println(today.with(taj3));

        // 이달의 마지막 화요일
        System.out.println(today.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY)));

        // 지난주 화요일(오늘 미포함)
        System.out.println(
                LocalDate.now()
                        .with(TemporalAdjusters
                                .previous(DayOfWeek.TUESDAY)
                        )
        );

        // 지난주 화요일(오늘 포함)
        System.out.println(LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY)));

        // 다음주 화요일(오늘 미포함)
        System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));

        // 다음주 화요일(오늘 포함)
        System.out.println(LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));

        // 이달의 4번째 화요일
        System.out.println(
                LocalDate.now()
                        .with(
                                TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.TUESDAY)
                        )
        );
    }
}

class DayAfterTomorrow implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        System.out.println("____temporal = " + temporal);
        return temporal.plus(2, ChronoUnit.DAYS);
    }
}