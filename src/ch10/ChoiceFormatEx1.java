package ch10;

import java.text.ChoiceFormat;

/*
* ChoiceFormat 은 특정범위에 속하는 숫자들을 문자열로 변환해준다.
* 마치 매퍼같은 역할이다
* 2 개의 배열을 이용하거나, 패턴 문자열 1개를 이용할 수 있다.
* 배열을 이용시 경계값을 지정하는 배열은 오름차순으로 정렬되어야만 한다.
* */
public class ChoiceFormatEx1 {
    public static void main(String[] args) {
        
        // 경계값 배열
        double[] limits = {60, 70, 80, 90}; // 오름차순 정렬 필수

        // 변환문자 배열
        String[] grades = {"D", "C", "B", "A"}; // 경계값 배열과 1대1 매치

        // ChoiceFormat 인스턴스
        ChoiceFormat form = new ChoiceFormat(limits, grades);

        // 변환할 값
        int[] scores = {100, 95, 88, 70, 52, 60, 70};

        // 변환
        for (int score : scores) {
            System.out.printf("%3d : %s%n",score, form.format(score));
        }


    }
}
