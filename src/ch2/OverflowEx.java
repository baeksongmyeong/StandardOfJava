package ch2;

public class OverflowEx {
    public static void main(String[] args) {

        System.out.println(Math.pow(2, 16));
        short sMin = -32768; // 2Byte = 1 + 15bit = -32768 ~ +32768
        short sMax = 32767;
        char cMin = 0; // 2Byte = 16bit = 0 ~ 65535
        char cMax = 65535;

        System.out.println("sMin   = "+sMin);
        System.out.println("sMin-1 = "+(sMin-1)); // 정수형의 사칙연산 결과는 int 가 되어 버리는 것 같다.
        System.out.println("sMin-1 = "+(short)(sMin-1));
        System.out.println("sMax   = "+sMax);
        System.out.println("sMax+1 = "+(short)(sMax+1));
        System.out.println("cMin   = "+(int)cMin);
        System.out.println("cMin-1 = "+(int)--cMin);
        System.out.println("cMax   = "+(int)cMax);
        System.out.println("cMax+1 = "+(int)++cMax);
    }
}
