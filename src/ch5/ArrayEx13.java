package ch5;

public class ArrayEx13 {
    public static void main(String[] args) {
        // char 배열 hex C A F E ( 16진수 문자만 입력한다고 가정 )
        char[] hex = {'C', 'A', 'F', 'E'};

        // String 배열 binary 0000 -> 1111 ( 16진수를 2진수로 나타내는 표 )
        String[] binary = { "0000", // 0
                            "0001", // 1
                            "0010", // 2
                            "0011", // 3
                            "0100", // 4
                            "0101", // 5
                            "0110", // 6
                            "0111", // 7
                            "1000", // 8
                            "1001", // 9
                            "1010", // A
                            "1011", // B
                            "1100", // C
                            "1101", // D
                            "1110", // E
                            "1111"  // F
        };

        String result = "";

        for (int i = 0; i < hex.length; i++) {
            
            // hex 배열 요소값이 0 ~ 9 사이의 문자이면
            if(hex[i] >= '0' && hex[i] <= '9'){
                result = result + binary[hex[i] - '0'];
                System.out.println("hex : " + hex[i] + ", binary : " + result);

            }
            // hex 배열 요소값이 0 ~ 9 사이의 문자가 아니라면
            else{
                System.out.println(hex[i] - 'A');
                System.out.println(hex[i] - 'A' + 10);
                result = result + binary[hex[i] - 'A' + 10];
                System.out.println("hex : " + hex[i] + ", binary : " + result);
            }

        }

        // char 배열을 String 으로 만들수 있다.
        System.out.println("hex : " + new String(hex));
        System.out.println("binary : " + result);

    }
}
