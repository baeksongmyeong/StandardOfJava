package ch12;

/*
* 열거형에 추상 메서드 추가
*   - 열거형에 추상 메서드가 들어있는 경우
*   - 각 상수는 이를 구현하는 코드가 들어가야 한다.
*
* */

// 클래스의 한 종류이며, 열거라는 제약이 존재하는 enum
enum Transportation {

    // Transportation 타입의 인스턴스를 만드는 생성자
    // 결국, enum 은 로딩되는 시점에 자기가 포함하고 있는 상수들의 인스턴스들을 만드는 것이다.
    BUS(100){
        @Override
        int fareIllegal(int distance) {
            return this.BASIC_FARE * distance + 1;
        }
    }
    ,TRAIN(150) {
        @Override
        int fareIllegal(int distance) {
            return this.BASIC_FARE * distance + 2;
        }
    },SHIP(100) {
        @Override
        int fareIllegal(int distance) {
            return this.BASIC_FARE * distance + 3;
        }
    },AIRPLANE(300) {
        @Override
        int fareIllegal(int distance) {
            return this.BASIC_FARE * distance + 4;
        }
    };

    // 상수는 생성자에서 초기화 할 수 있다.
    final int BASIC_FARE;

    // 생성자
    Transportation(int BASIC_FEE) {
        this.BASIC_FARE = BASIC_FEE;
    }

    // 기본요금 반환
    int getBasicFare(){
        return BASIC_FARE;
    }

    // 거리에 따른 요금 반환
    int fare(int distance) {
        return this.BASIC_FARE * distance;
    }

    // 추상메서드로 폭리를 받을수 있게 함
    abstract int fareIllegal(int distance);
}

public class EnumEx3 {
    public static void main(String[] args) {
        // 열거형 상수의 인스턴스 참조하기
        Transportation bus = Transportation.valueOf("BUS");
        Transportation train = Transportation.TRAIN;
        Transportation ship = Enum.valueOf(Transportation.class, "SHIP");
        Transportation airplane = Transportation.AIRPLANE;

        // 거리에 따른 요금 계산
        System.out.println(bus.fare(10));
        System.out.println(train.fare(10));
        System.out.println(ship.fare(10));
        System.out.println(airplane.fare(10));
        
        // 추상메서드 구현 호출
        System.out.println(bus.fareIllegal(10));
        System.out.println(train.fareIllegal(10));
        System.out.println(ship.fareIllegal(10));
        System.out.println(airplane.fareIllegal(10));
    }


}
