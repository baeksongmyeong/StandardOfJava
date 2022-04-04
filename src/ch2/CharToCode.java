package ch2;

public class CharToCode {
    public static void main(String[] args) {
        char ch = 'A';
        int code = ch;
        System.out.printf("%c=%d(%#X)%n", ch, code, code);
        char hch = '가';
        System.out.printf("%c=%d(%#X)%n", hch, (int)hch, (int)hch);
        char intCh = 66;
        System.out.printf("%c=%d(%#X)%n", intCh, (int)intCh, (int)intCh);
    }
}
