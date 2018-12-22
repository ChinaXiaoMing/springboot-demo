package threadPool;

import java.io.IOException;

public class Test {

    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    public static String lineToHump(String str) {
        String[] arr = str.split("_");
        StringBuilder stringBuilder = new StringBuilder(arr[0]);
        for (int i = 1; i <arr.length; i++) {
            stringBuilder.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        String str = "abcHelloWorld";
        String transformStr = Test.humpToLine(str);
        System.out.println(transformStr);
        String other = lineToHump("abc_def_ghi");
        System.out.println(other);
    }

}
