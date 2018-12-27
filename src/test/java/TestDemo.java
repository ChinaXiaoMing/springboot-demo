import annotation.SomeDaoImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @Descript DOTO
 * @Author fuyuanming
 * @Date 2018-07-17 08:43:28
 * @Version 1.0
 */
public class TestDemo {

    public static void main(String[] args) {

        Set set = new HashSet();
        set.add(1);
        set.add("hello");
        System.out.println(set.add(1));
        set.stream().forEach(x-> System.out.println(x));

    }

}
