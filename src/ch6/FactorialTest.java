package ch6;

import java.util.Scanner;

public class FactorialTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inNumber = 0;

        while (true) {

            // 입력
            System.out.printf("양수를 입력하세요. (종료는 0) > ");
            String inString = scanner.nextLine();
            
            // 정수변환
            try{
                inNumber = Integer.parseInt(inString);
            }catch(Exception e){
                System.out.printf("정수변환오류. 입력값:[%s]%n", inString);
                continue;
            }

            // 0 입력시 종료
            if(inNumber == 0) break;

            // Factorial 계산
            int result = factorial(inNumber);
            System.out.println(result);

        }

    }

    // factorial 메서드. 재귀 메서드
    static int factorial(int n){
        if(n == 1) {
            System.out.printf("%d=", n);
            return 1;
        }
        System.out.printf("%d*", n);
        return n * factorial(n - 1);
    }

}
