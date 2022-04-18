package ch9;

/*
* 래퍼 클래스의 인스턴스를 만드는 방법
* 1. 생성자
* 2. parseXXX
* 3. valueOf
* */

public class WrapperEx2 {
    public static void main(String[] args) {

        // 래퍼 클래스의 인스턴스 생성. 문자열 이용
        int     i  = new Integer("100").intValue();
        int     i2 = Integer.parseInt("100");
        Integer i3 = Integer.valueOf("100");

        // 문자열의 진법을 설정하여 10진수로 변경한 값을 저장한 래퍼 클래스의 인스턴스 생성
        int i4 = Integer.parseInt("100", 2);
        int i5 = Integer.parseInt("100", 8);
        int i6 = Integer.parseInt("100", 16);
        int i7 = Integer.parseInt("FF", 16);

        try{
            int i8 = Integer.parseInt("FF", 2);
        } catch ( Exception e ){
            System.out.println("Integer.parseInt(\"FF\", 2) - FF 는 올바른 진법이 정해져야 변환이 가능합니다.");
        }

        Integer i9 = Integer.valueOf("100", 2);
        Integer i10 = Integer.valueOf("100", 8);
        Integer i11 = Integer.valueOf("100", 16);
        Integer i12 = Integer.valueOf("FF", 16);
        try{
        Integer i13 = Integer.valueOf("FF");
        } catch ( Exception e ){
            System.out.println("Integer.valueOf(\"FF\") - FF 는 올바른 진법이 정해져야 변환이 가능합니다.");
        }

    }
}
