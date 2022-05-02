package ch11;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet<>();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
        for (int i : score) {set.add(i);}
        System.out.println(set.headSet(50));
        System.out.println(set.tailSet(50));
    }
}
