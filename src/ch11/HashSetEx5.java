package ch11;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx5 {
    public static void main(String[] args) {
        Set setA   = new HashSet<>();
        Set setB   = new HashSet<>();
        Set setHab = new HashSet<>();
        Set setKyo = new HashSet<>();
        Set setCha = new HashSet<>();

        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");

        setB.add("4");
        setB.add("5");
        setB.add("6");
        setB.add("7");
        setB.add("8");
        
        // 합집합
        setHab.addAll(setA);
        setHab.addAll(setB);
        
        // 교집합
        setKyo.addAll(setA);
        setKyo.retainAll(setB);
        
        // 차집합
        setCha.addAll(setA);
        setCha.removeAll(setB);

        System.out.println(setHab);
        System.out.println(setKyo);
        System.out.println(setCha);
    }
}
