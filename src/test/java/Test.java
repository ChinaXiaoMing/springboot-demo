public class Test {

    public static int getMaxLengthOfSubstr(String str) {
        char c1, c2;
        int len = 0, temp = 0;
        for (int i = 0; i < str.length(); i++) {
            c1 = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                c2 = str.charAt(j);
                if (c1 == c2 && i != j) {
                    temp = j - i + 1;
                    if (temp >= len) {
                        len = temp;
                    }
                    break;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "sdsaddas";
        String str1 = "sadasdwe";
        int result = getMaxLengthOfSubstr(str);
        int result1 = getMaxLengthOfSubstr(str1);
        System.out.println(result);
        System.out.println(result1);

    }

}
