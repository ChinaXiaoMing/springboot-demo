package annotation;

public class SomeDaoImpl {

    @MyTest(time = 100L)
    public void save() {
        System.out.println("保持了数据");
    }

    public void update() {
        System.out.println("更新了数据");
    }


}
