package annotation;

import java.lang.reflect.Method;

/**
 * @Description DOTO
 * @Author xiaoming
 * @Date 2020/3/19 22:24
 * @Version 1.0
 **/
public class AnnotationHandler {

    public void Handler() {
        Class clazz = SomeDaoImpl.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                System.out.println("hello");
            }
        }
    }

}
