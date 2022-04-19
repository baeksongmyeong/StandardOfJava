package ch9;

import java.util.Random;

/*
* Random 클래스에 대해 알아본다.
* Math.random 메서드는 Random 클래스의 인스턴스를 생성해서 메서드를 호출하는 구조이다.
* 같은 종자값을 가지는 Random 클래스의 인스턴스들은 nextInt 등의 메서드를 호출할때마다 같은 값을 리턴한다. ( 호출 순서별로 값이 같다는 의미이다 )
* */
public class RandomEx1 {
    public static void main(String[] args) {
        Random rand  = new Random(1);
        Random rand2 = new Random(1);

        System.out.println("= rand =");
        for (int i = 0; i < 5; i++) { System.out.println(i + ":" + rand.nextInt()); }

        System.out.println();

        System.out.println("= rand2 =");
        for (int i = 0; i < 5; i++) { System.out.println(i + ":" + rand2.nextInt()); }
    }
}
