package annotation;

public class SomeDaoImplTest {

    private SomeDaoImpl someDao = new SomeDaoImpl();

    @MyTest
    public void save() {
        someDao.save();
    }

    @MyTest
    public void update() {
        someDao.update();
    }

}
