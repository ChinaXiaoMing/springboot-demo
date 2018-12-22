package concurrent;

public class Test {

    public static void appendStr(String str) {
        str = str + "5";
        System.out.println(str);
    }

    public static void main(String[] args) {
        String str = "1234";
        appendStr(str);
        System.out.println(str);
    }

}
