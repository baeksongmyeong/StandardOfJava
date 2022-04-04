package ch2;

public class StringEx {
    public static void main(String[] args) {
        String name = "Ja" + "va";
        String str = 8.0 + name;
        System.out.println(name);
        System.out.println(str);
        System.out.println(7 + " "); // "7 "
        System.out.println(" " + 7); // " 7"
        System.out.println(7 + ""); // "7"
        System.out.println("" + 7); // "7"
        System.out.println("" + ""); // ""
        System.out.println(7 + 7 + ""); // "14"
        System.out.println("" + 7 + 7); // "77"
    }
}
