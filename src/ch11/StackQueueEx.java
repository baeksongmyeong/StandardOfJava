package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackQueueEx {
    public static void main(String[] args) {
        
        // Stack 인스턴스 생성
        Stack<Object> stack = new Stack<Object>();
        
        // LinkedList 인터페이스를 구현한 LinkedList 인스턴스 생성
        LinkedList<Object> queue = new LinkedList<Object>();

        // Stack 에 요소 추가
        stack.push("0");
        stack.push("1");
        stack.push("2");

        // Queue 에 요소 추가
        queue.offer("0");
        queue.offer("1");
        queue.offer("2");

        System.out.printf("=Stack=%n");
        while (!(stack.isEmpty())){
            System.out.printf("%s -> ", stack.pop());
        }

        System.out.printf("%n");

        System.out.printf("=Queue=%n");
        while (!(queue.isEmpty())){
            System.out.printf("%s -> ", queue.poll());
        }
    }
}
