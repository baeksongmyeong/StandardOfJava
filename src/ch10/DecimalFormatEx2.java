package ch10;

import java.text.DecimalFormat;
import java.text.ParseException;

/*
* DecimalFormat 의 parse(String) 메서드를 이용하면, 형식화된 문자열을 Number 타입 인스턴스로 변환할 수 있다.
* 단, 문자열의 형식과 DecimalFormat 인스턴스의 형식이 일치해야 정상적인 값을 얻을수 있다.
* */
public class DecimalFormatEx2 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#.###E0");

        try {
            Number num = df.parse("1,234,567.89");
            System.out.println(num);

            double d = num.doubleValue();
            System.out.println(d);
            System.out.println(df2.format(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
