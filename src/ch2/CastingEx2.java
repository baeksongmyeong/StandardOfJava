package ch2;

public class CastingEx2 {
    public static void main(String[] args) {
        int i = 10;
        byte b = (byte)i; // byte = 1byte = 1 + 7bit = -128 ~ +127
        System.out.printf("(int -> byte) i=%d -> b=%d%n", i, b);


        // 0    -> 127 : 0 부터 시작.     여기까지 128 소모. 총 128
        // -128 ->  -1 : 오버플로우 발생.  여기까지 127 소모. 총 255
        // 0    ->  44 : 0 부터 다시 시작. 여기까지 45 소모. 총 300
        i = 300;
        b = (byte)i;
        System.out.printf("(int -> byte) i=%d -> b=%d%n", i, b);

        b = -2;
        i = (int)b;
        System.out.printf("(int -> byte) i=%d -> b=%d%n", i, b);

        System.out.printf("i="+Integer.toBinaryString(i));


    }
}
