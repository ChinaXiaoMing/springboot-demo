package math;

public class MathTest {

    public static void change(int[] a) {
        a[0] = 50;
    }

    public static void main(String[] args) {
        int[] a = {10, 10};
        System.out.println(a[0]);
        change(a);
        System.out.println(a[0]);
    }

}
