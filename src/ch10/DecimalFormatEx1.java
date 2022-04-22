package ch10;

import java.text.DecimalFormat;

public class DecimalFormatEx1 {
    public static void main(String[] args) {
        double number = 1234567.89;
        String[] pattern = {
                "0", // 소수점이 반올림되어서 출력
                "#", // 소수점이 반올림되어서 출력
                "0.0", // 소수점이 2째자리에서 반올림되어서 출력
                "#.#", // 소수점이 2째자리에서 반올림되어서 출력
                "0000000000.0000", // 값이 없는 자리수도 0 을 채움
                "##########.####", // 값이 없는 자리수는 표현안함
                "#.#-", // 기호
                "-#.#", // 기호
                "#,###.##", // 자리수 콤마
                "#,####.##", // 자리수 콤마
                "#E0",
                "0E0",
                "##E0",
                "00E0",
                "####E0",
                "0000E0",
                "#.#E0",
                "0.0E0",
                "0.00000000E0",
                "00.0000000E0",
                "000.000000E0",
                "#.########E0",
                "##.#######E0",
                "###.######E0",
                "#,###.##+;#,###.##-",
                "#.#%",
                "#.#\u2030",
                "\u00A4 #,###", // 통화
                "'#'#,###", // 이스케이프
                "''#,###"
        };

        for (int i = 0; i < pattern.length; i++) {
            DecimalFormat df = new DecimalFormat(pattern[i]);
            System.out.printf("%19s : %s%n", pattern[i], df.format(number));
        }

    }
}
