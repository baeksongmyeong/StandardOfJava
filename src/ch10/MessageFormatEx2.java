package ch10;

import java.text.MessageFormat;

public class MessageFormatEx2 {
    public static void main(String[] args) {
        String tableName = "CUST_INFO";
        String msg = "INSERT INTO " + tableName
                + " VALUES ( "
                + "''{0}'',"
                + "''{1}'',"
                + "''{2}'',"
                + "''{3}''"
                + ");"
                ;

        Object[][] arg = {
                {"이자바", "02-123-1234", "27", "07-09"}
                ,{"김프로", "032-543-1234", "41", "57-01"}
        };

        for (Object[] objects : arg) {
            String result = MessageFormat.format(msg, objects);
            System.out.println(result);
        }

    }
}
