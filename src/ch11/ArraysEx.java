package ch11;

import java.util.Arrays;

/*
* Arrays 클래스에는 배열을 다루기 편하게 하는 메서드들이 구현되어 있다.
*
* Arrays.copyOf(int)
* Arrays.copyOfRange(int, int)
* Arrays.fill(Object[], Object)
* Arrays.setAll(Object[], 함수형 인터페이스 구현체 | 람다식)
* Arrays.sort(Object[])
* Arrays.binarySearch(Object[], Object)
* Arrays.equals(Object[], Object[])
* Arrays.deepEquals(Object[], Object[])
* Arrays.asList(Object[] || Object...)
* */
public class ArraysEx {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] arr2D = {
                {11, 12, 13},
                {21, 22, 23}
        };

        // 1차원 배열의 출력
        System.out.println(Arrays.toString(arr));

        // 다차원 배열의 출력
        System.out.println(Arrays.deepToString(arr2D));

        Object[] a = {1, 2, 3};
        //System.out.println(Arrays.deepToString(a)); // 1차원도 출력은 되는데 Object 타입이여야 한다.

        // 배열의 복사
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, 3);
        int[] arr4 = Arrays.copyOf(arr, 7); // 원본 요소가 없으면 기본값으로 채워짐

        int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7); // 원본 요소가 없으면 기본값으로 채워짐

        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("arr4 = " + Arrays.toString(arr4));
        System.out.println("arr5 = " + Arrays.toString(arr5));
        System.out.println("arr6 = " + Arrays.toString(arr6));

        // 배열을 특정값으로 모두 채우기
        int[] arr7 = new int[5];
        Arrays.fill(arr7, 9);
        System.out.println("arr7 = " + Arrays.toString(arr7));
        
        // 배열을 함수형 인터페이스 또는 람다식의 결과로 채우기
        Arrays.setAll(arr7, i -> (int)(Math.random() * 6) + 1);
        System.out.println("arr7 = " + Arrays.toString(arr7));

        for (int i : arr7) {
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(Arrays.toString(graph) + i);
        }

        String[][] str2D = new String[][]{
                {"aaa", "bbb"},
                {"AAA", "BBB"}
        };

        String[][] str2D2 = new String[][]{
                {"aaa", "bbb"},
                {"AAA", "BBB"}
        };

        // 2차원 배열이 같은지 비교
        System.out.println(Arrays.equals(str2D, str2D2));
        System.out.println(Arrays.deepEquals(str2D, str2D2));

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        System.out.println(Arrays.toString(chArr));
        
        // 정렬되지 않은 상태에서 배열 내 요소 위치 검색
        System.out.println(Arrays.binarySearch(chArr, 'B'));

        // 배열 내 요소 정렬
        Arrays.sort(chArr);
        System.out.println(Arrays.toString(chArr));

        // 배열 내 요소 위치 검색
        System.out.println(Arrays.binarySearch(chArr, 'B'));
    }
}