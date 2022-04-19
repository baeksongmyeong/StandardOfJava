package ch9;

import java.util.StringTokenizer;

public class StringTokenizerEx4 {
    public static void main(String[] args) {
        String input = "이억삼천오백이십일만이천삼백오십구";
        System.out.println(input);
        System.out.println(hangulToNum(input));
    }

    public static long hangulToNum(String input){

        long result    = 0; // 만단위 이상 숫자를 저장
        long tmpResult = 0; // 만단위 미만, 십단위 이상 숫자를 저장
        long num       = 0; // 문자가 숫자인 경우, 이를 저장. 일단위 숫자 저장

        // 토큰의 문자가 숫자인지 확인하기 위한 대조표 ( 실제 숫자와 문자열의 인덱스가 동일 )
        final String NUMBER = "영일이삼사오육칠팔구";

        // 토큰의 문자가 단위인지 확인하기 위한 대조표
        final String UNIT = "십백천만억조";

        // 토큰의 문자가 단위인 경우, 실제 단위를 곱해주기 위한 대조표 ( 배열의 인덱스 순서와, "십백천만억조" 의 각 문자 인덱스 순서가 동일 )
        final long[] UNIT_NUM = {10, 100, 1000, 10000, (long) 1e8, (long) 1e12};

        StringTokenizer st = new StringTokenizer(input, UNIT, true);

        while (st.hasMoreTokens()){

            // 문자 확인
            String token = st.nextToken();
            System.out.printf("토큰 : %s%n", token);

            // 숫자인지 확인하기 위해 숫자 대조표 내에 있는 문자인지 검증
            int check = NUMBER.indexOf(token);

            // 단위인 경우
            if(check == -1){

                // 단위 대조표상 인덱스를 확인해서 실제 단위 숫자를 조회
                int unit_index = UNIT.indexOf(token);
                long unit_amount = UNIT_NUM[unit_index];
                System.out.printf("    단위 %d%n", unit_amount);

                // 단위가 만, 억, 조가 아닌 경우
                if("만억조".indexOf(token)==-1){
                    System.out.printf("        숫자 [%d], 임시결과 [%d]", num, tmpResult);
                    tmpResult = tmpResult + (num != 0 ? num : 1) * unit_amount;
                    System.out.printf(" -> [%d], 최종결과 [%d]%n", tmpResult, result);
                }
                // 단위가 만, 억, 조인 경우
                else{
                    System.out.printf("        숫자 [%d], 임시결과 [%d]", num, tmpResult);
                    tmpResult = tmpResult + num;
                    System.out.printf(" -> [%d], 최종결과 [%d]", tmpResult, result);
                    result = result
                            + (tmpResult != 0 ? tmpResult : 1) * unit_amount;
                    System.out.printf(" -> [%d]%n", result);
                    tmpResult = 0;
                }

                num = 0;

            }
            // 숫자인 경우
            else{
                // check 는 문자열내 인덱스이므로, 문자가 나타내려는 숫자와 동일한 값이다.
                num = check;
                System.out.printf("    숫자 -> %d", num);
                System.out.println();
            }

        }

        System.out.printf("[%10d]%n",result);
        System.out.printf("[%10d]%n",tmpResult);
        System.out.printf("[%10d]%n",num);
        return result + tmpResult + num;

    }
}
