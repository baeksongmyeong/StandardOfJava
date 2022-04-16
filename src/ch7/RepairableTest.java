package ch7;

/*
관계가 없는 클래스들을 하나의 인터페이스를 구현하게 하여 관계를 맺어주고,
이 인터페이스 타입의 참조변수로 인터페이스를 구현한 클래스들의 인스턴스들을 모두 참조할 수 있게 하는 것을 구현
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class RepairableTest {
    public static void main(String[] args) {
        Tank1 tank = new Tank1();
        Dropship1 dropship = new Dropship1();
        Marine1 marine = new Marine1();
        SCV1 scv = new SCV1();
        tank.hitPoint = 120;
        scv.repair(tank);
        dropship.hitPoint = 100;
        scv.repair(dropship);
        scv.hitPoint = 40;
        scv.repair(scv);
        marine.hitPoint = 5;
        //scv.repair(marine); // repair 메서드의 매개변수인 Repairable 인터페이스를 구현한 클래스의 인스턴스가 아니므로 인자로 사용할 수 없음.
    }
}

class Unit1 {
    final int MAX_HP; // 최대 체력
    int hitPoint; // 현재 체력
    Unit1(int maxHp){ this.MAX_HP = maxHp; }
}

class GroundUnit1 extends Unit1 {
    GroundUnit1(int maxHp){ super(maxHp); }
}

class AirUnit1 extends Unit1 {
    AirUnit1(int maxHp){ super(maxHp); }
}

//////////////////////////////////////
// 수리가능 : Tank, Dropship, SCV => 하나의 타입으로 묶어서 메서드를 하나만 만들수 있게 하자.
//////////////////////////////////////
interface Repairable {}

class Tank1 extends GroundUnit1 implements Repairable {
    Tank1(){
        super(150);
        hitPoint = MAX_HP; // 인스턴스 생성시 현재 체력은 최대 체력으로 설정
    }
    @Override public String toString(){ return "Tank"; }
}

class Dropship1 extends AirUnit1 implements Repairable {
    Dropship1(){
        super(125);
        hitPoint = MAX_HP; // 인스턴스 생성시 현재 체력은 최대 체력으로 설정
    }
    @Override public String toString(){ return "Dropship"; }
}

class Marine1 extends GroundUnit1 {
    Marine1(){
        super(40);
        hitPoint = MAX_HP; // 인스턴스 생성시 현재 체력은 최대 체력으로 설정
    }
    @Override public String toString(){ return "Marine"; }
}

class SCV1 extends GroundUnit1 implements Repairable {
    SCV1(){
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable r){
        if( r instanceof Unit1){
            Unit1 u = (Unit1)r;
            System.out.printf("현재 hitPoint : %d%n", u.hitPoint);
            String[] hpArr = new String[u.MAX_HP];
            
            // 초기화
            for(int i = 0 ; i < hpArr.length ; i++){
                if(i <= u.hitPoint -1){
                    hpArr[i] = "O";
                }else{
                    hpArr[i] = " ";
                }
            }

            printHitPoint(hpArr);

            while(u.hitPoint != u.MAX_HP){
                ++u.hitPoint;
                hpArr[u.hitPoint-1] = "O";
                printHitPoint(hpArr);
            }
            System.out.println(u + " 의 수리가 끝났습니다.");
        }
    }

    void printHitPoint(String[] hpArr){
        System.out.print("[");
        for( String hp : hpArr){
            System.out.print(hp);
        }
        System.out.print("]");
        System.out.println();
    }

    @Override public String toString(){ return "SCV"; }
}


