package ch12;

import java.util.ArrayList;

/*
* 지네릭 타입의 형변환
*   - 지네릭 타입이 적용된 참조변수와 그 원형인 원시 타입 참조변수 간에는 형변환이 가능
*   - 서로 다른 타입변수가 적용된 지네릭 타입 참조변수간에는 형변환이 불가
*   - 와일드 카드가 적용된 참조변수와 타입변수가 적용된 지네릭 타입 참조변수 간에는 형변환이 가능
*   - 서로 다른 타입변수가 적용된 지네릭 타입 참조변수간에는 중간 매개체로 와일드 카드가 적용된 참조변수를 통해 형변환을 할 수 있음
* */
public class GenericTypeChange {
    public static void main(String[] args) {

        Box_2 box = new Box_2();
        Box_2<Object> objBox = new Box_2<>();
        Box_2<String> strBox = new Box_2<>();

        // 지네릭타입(Object 적용) <-> 원시타입 형변환 가능
        box    = (Box_2<Object>) objBox;
        objBox = (Box_2) box;

        // 서로 다른 타입이 적용된 지네릭 클래스간 형변환은 불가
        //objBox = (Box_2<Object>)strBox;
        //strBox = (Box_2<String>)objBox;
        
        // 위에서는 오브젝틑 클래스를 타입변수로 사용한 변수와도 형변환이 안되었지만
        // 와일드 카드를 사용한 형변환은 가능
        Box_2<? extends Object> wBox = strBox;


        // 그래서, 아래와 같이 와일드 카드를 이용하면
        // 서로 다른 타입변수가 대입된 참조변수와 인스턴스인 경우에도
        // 형변환을 할 수 있다.
        // 하지만 확인되지 않은 타입으로의 형변환이라는 경고가 발생한다.
        Box_2<?> wBox2 = strBox;
        Box_2<Object> objBox2 = (Box_2<Object>)wBox2;




        
    }
}

class Box_2<T> {
    ArrayList<T> list = new ArrayList<>();
}

