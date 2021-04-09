package annotation;


import java.util.Optional;

/**
 * @Description
 * @Author xiaoming
 * @Date 2020-03-19 22:18:15
 * @Version 1.0
 **/
public class MyTestRunner {

    public static void main(String[] args) {
        try {
            MyTestRunner.hello();
        } catch (Exception e) {
            System.out.println("hello world");
        }
    }

    private static void hello() throws Exception {
        String str = null;
        String str1 = "hello";
        if (str == null) {
            System.out.println("str");
        }
        else if (str1 == null) {
            System.out.println("str1");
        }
        System.out.println("hello");
    }

}
