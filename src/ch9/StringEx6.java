package ch9;

/*
* Stiring.format : 형식화된 String 인스턴스를 생성한다.
* 기본타입 -> String 타입으로 형변환 : String.valueOf() 메서드 사용
* String 타입 -> 기본타입으로 형변환 : 기본타입의 래퍼클래스.valueOf() 메서드 사용 또는 래퍼클래스.parseInt() 등의 메서드 사용
* */

public class StringEx6 {
    public static void main(String[] args) {

        // 형식화된 String 인스턴스 생성
        String str = String.format("%s 는 나이가 %d 입니다.", "가나다", 20);
        System.out.println(str);

        // 기본타입 -> String타입 형변환
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf('A'));
        System.out.println(String.valueOf(1));
        System.out.println(String.valueOf(1L));
        System.out.println(String.valueOf(1.0F));
        System.out.println(String.valueOf(10.0D));

        // String타입 -> 기본타입 형변환 : 래퍼 클래스의 valueOf() 메서드 사용
        Boolean.valueOf("true");
        Character.valueOf("A".charAt(0));
        Integer.valueOf("1 ".trim());
        Long.valueOf("1");
        Float.valueOf("1.0");
        Double.valueOf("1.0");

        // String타입 -> 기본타입 형변환 : 래퍼 클래스의 parseXXX() 메서드 사용
        Boolean.parseBoolean("true");
        Integer.parseInt("1");
        Long.parseLong("1");
        Float.parseFloat("1.0");
        Double.parseDouble("1.0");




    }
}
