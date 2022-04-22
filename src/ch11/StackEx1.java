package ch11;

import java.util.Stack;

public class StackEx1 {

    static Stack back    = new Stack<Object>();
    static Stack forward = new Stack<Object>();

    public static void main(String[] args) {
        goURL("1.네이트");
        goURL("2.야후");
        goURL("3.네이버");
        goURL("4.다음");

        printStatus();

        System.out.printf("%n=뒤로가기 클릭=%n");
        goBack();

        printStatus();

        System.out.printf("%n=뒤로가기 클릭=%n");
        goBack();

        printStatus();

        System.out.printf("%n=앞으로가기 클릭=%n");
        goForward();

        printStatus();

        System.out.printf("%n=새로운 주소로 이동=%n");
        goURL("codechobo.com");

        printStatus();
    }

    public static void printStatus(){
        System.out.printf("back    : %s%nforward : %s%n현재화면은 %s 입니다.%n", back, forward, back.peek());
    }

    public static void goURL(String url) {
        back.push(url);
        if(!forward.empty()) forward.clear();
    }

    public static void goForward() {
        if (!forward.isEmpty()) back.push(forward.pop());
    }

    public static void goBack(){
        if (!back.empty()) forward.push(back.pop());
    }
}
