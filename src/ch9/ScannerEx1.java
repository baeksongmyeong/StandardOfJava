package ch9;

import java.io.InputStream;
import java.util.Scanner;

/*
* Scanner 클래스를 통해 화면, 파일, 문자열등으로부터 입력을 받을 수 있다.
* 이번 예제는 화면으로부터 입력받는 예이다.
* 입력을 받는 것은 nextLine() 메서드를 호출함으로써 진행된다.
* */
public class ScannerEx1 {
    public static void main(String[] args) {
        InputStream is = System.in;
        Scanner s = new Scanner(is);
        String[] argArr = null;

        while (true){
            String prompt = ">>";
            System.out.print(prompt);

            String input = s.nextLine();

            input = input.trim();
            argArr = input.split(" +"); // 공백을 구분자로 하여 잘라서 배열에 저장

            String command = argArr[0].trim();

            if("".equals(command)) continue;

            command = command.toLowerCase();

            if("q".equals(command)){
                System.exit(0);
            }else{
                for (int i = 0; i < argArr.length; i++) {
                    System.out.println(argArr[i]);
                }    
            }

        }

    }
}
