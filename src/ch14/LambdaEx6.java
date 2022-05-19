package ch14;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.function.*;
/*
* 함수형 인터페이스를 사용할 때, 지네릭을 이용하는 것을 배워왔는데, 기본형의 입력, 출력을 지원하는 함수형 인터페이스도 존재한다.
* 기본형을 쓰는 경우에는 지네릭 함수형 인터페이스를 쓰면, 오토박싱, 언박싱이 사용되므로 성능이 나빠진다.
* 따라서 기본형을 쓸 때에는 기본형을 지원하는 함수형 인터페이스를 써야한다.
*
* 1) A Function<T> : 입력이 A, 리턴이 지네릭
*       IntFunction<Integer>
*       LongFunction<Integer>
*       DoubleFunction<Integer>
*
* 2) To A Function<T> : 입력이 지네릭, 리턴이 A
*       ToIntFunction<Integer>
*       ToLongFunction<Integer>
*       ToDoubleFunction<Integer>
*
* 3) A To B Function : 입력이 A, 출력이 B
*       IntToDoubleFunction
*       IntToLongFunction
*       LongToIntFunction
*       LongToDoubleFunction
*       DoubleToIntFunction
*       DoubleToLongFunction
*
* 4) Obj A Cousumer<T> : A 와 지네릭, 출력은 없음
*       ObjIntConsumer<Integer>
*       ObjLongConsumer<Integer>
*       ObjDoubleConsumer<Integer>
*
*/
public class LambdaEx6 {
    public static void main(String[] args) {
        
        // int 기본형 지원 Supplier 함수형 인터페이스 생성. 1 부터 100 까지의 난수 생성
        IntSupplier s = () -> (int) (Math.random() * 100) + 1;

        // int 기본형 지원 Consumer 함수형 인터페이스 생성. 입력값을 출력
        IntConsumer c = i -> System.out.printf("%d, ", i);
        
        // int 기본형 지원 Predicate 함수형 인터페이스 생성. 2의 배수이면 참
        IntPredicate p = i -> i % 2 == 0;
        
        // int 기본형 지원 UnaryOperator 함수형 인터페이스 생성. 입력값의 1 의 자리 제거값 반환
        IntUnaryOperator op = i -> (i / 10) * 10;
        
        // 10 개의 요소를 가지는 int 배열 생성
        int[] arr = new int[10];

        // 난수 생성 및 배열에 저장
        makeRandomList(s, arr);
        
        // 배열값 출력
        System.out.println(Arrays.toString(arr));
        
        // 짝수만 출력
        printEvenNum(p, c, arr);

        // 새로운 배열 생성
        int[] newArr = doSomething(op, arr);

        // 새로운 배열 출력
        System.out.printf("%s", Arrays.toString(newArr));
    }

    public static void makeRandomList(IntSupplier s, int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] = s.getAsInt();
    }

    public static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
        System.out.printf("[");
        for (int i : arr) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
        System.out.printf("]%n");
    }

    public static int[] doSomething(IntUnaryOperator op, int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) newArr[i] = op.applyAsInt(arr[i]);
        return newArr;
    }
}
