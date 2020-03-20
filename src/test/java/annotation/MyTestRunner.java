package annotation;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author xiaoming
 * @Date 2020-03-19 22:18:15
 * @Version 1.0
 **/
public class MyTestRunner {

    public static void main(String[] args) {

        SomeDaoImpl someDao = new SomeDaoImpl();
        someDao.save();
        someDao.update();

    }

}
