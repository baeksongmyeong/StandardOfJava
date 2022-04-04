package ch2;

public class PrintEx1 {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        char c = 'A';

        int finger = 10;
        long big = 100_000_000_000L;
        long hex = 0xFFFF_FFFF_FFFF_FFFFL;

        int octNum = 010;  // 숫자 앞에 0  을 넣으면 8진수로 인식
        int hexNum = 0x10; // 숫자 앞에 0x 를 넣으면 16진수로 인식
        int binNum = 0b10; // 숫자 앞에 b  를 넣으면 2진수로 인식

        System.out.printf("b=%d%n", b); // 10진수 표시 %d
        System.out.printf("s=%d%n", s);
        System.out.printf("c=%c, %d%n", c, (int)c); // char 표시 %c
        System.out.printf("finger=[%5d]%n", finger); // % 패딩길이 d
        System.out.printf("finger=[%-5d]%n", finger); // % 좌우정렬 패딩길이 d
        System.out.printf("finger=[%05d]%n", finger); // % 패딩값 패딩길이 d
        System.out.printf("big=%d%n", big);
        System.out.printf("hex=%#x%n", hex);
        System.out.printf("octNum=%o, %d%n", octNum, octNum); // 정수를 8진수로 변환하여 출력 %o
        System.out.printf("hexNum=%x, %d%n", hexNum, hexNum); // 정수를 16진수로 변환하여 출력 %x
        System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum); // 정수를 2진수로 변환하여 출력하는 지시자는 없음

    }
}
