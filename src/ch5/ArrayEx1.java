package ch5;

public class ArrayEx1 {

    public static void main(String[] args) {

        int[] score = new int[5]; // new int[길이]
        int k = 1;

        score[0] = 50;
        score[1] = 60;
        score[k + 1] = 70; // 배열 인덱스에 변수사용가능
        score[3] = 80;
        score[4] = 90;

        int tmp = score[k + 2] + score[4];

        for(int i = 0; i < 5; i++){
            System.out.printf("score[%d]:%d%n",i, score[i]);
        }

        System.out.printf("tmp:%d%n", tmp);
        System.out.printf("score[%d]:%d%n", 7, score[7]); // 배열길이를 벗어나도 컴파일러는 못알아챔

    }

}
