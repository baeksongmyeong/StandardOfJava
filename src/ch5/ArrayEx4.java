package ch5;

public class ArrayEx4 {
    public static void main(String[] args) {
        // 문자배열 abc A ~ D
        char[] abc = new char[]{'A', 'B', 'C', 'D'};

        // 문자배열 num 0 ~ 9
        char[] num = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println(abc);
        System.out.println(num);

        // 배열 abc 와 num 을 붙혀서 하나의 배열(result) 로 만든다.
        char[] result = new char[abc.length + num.length];
        
        // abc 를 result 에 복사
        System.arraycopy(abc, 0, result, 0, abc.length);
        System.out.println(result);

        // num 을 result 에 복사
        System.arraycopy(num, 0, result, abc.length, num.length);
        System.out.println(result);

        // 배열 abc 를 배열 num 의 첫번째 위치부터 배열 abc 의 길이만큼 복사
        System.arraycopy(abc, 0, num, 0, abc.length);
        System.out.println(num);
        
        // 배열 num 의 인덱스 6 위치 이후 3개를 복사
        System.arraycopy(abc, 0, num, 6, 3);
        System.out.println(abc);
        System.out.println(num);



    }
}
