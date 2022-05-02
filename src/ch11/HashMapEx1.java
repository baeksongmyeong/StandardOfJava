package ch11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("id pw 입력");
            System.out.print("id : ");
            String id = s.nextLine().trim();

            // id 존재여부 확인
            if(map.containsKey(id)){
                System.out.print("pw : ");
                String pw = s.nextLine().trim();
                if(map.get(id).equals(pw)){
                    System.out.println("등록된 사용자");
                    break;
                }else{
                    System.out.println("pw 불일치");
                    continue;
                }
            }else{
                System.out.println("미등록id");
                continue;
            }
        }


    }
}
