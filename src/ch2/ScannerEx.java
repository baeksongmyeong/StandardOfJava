package ch2;

import java.util.Scanner;

public class ScannerEx {
    public static void main(String[] args) {

        final String QUIT = "Q";

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("두자리 정수를 하나 입력해주세요.>");
            String input = scanner.nextLine();

            if(QUIT.equals(input.toUpperCase())) break;

            try{
                int num = Integer.parseInt(input);
                System.out.println("입력내용="+input);
                System.out.printf("num=[%02d]%n", num);
            }catch(Exception e){
                System.out.println(e);
                System.out.println(e.getMessage());
            }
        }
    }
}
