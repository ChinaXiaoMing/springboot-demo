package utils;

import com.opencode.redis.Person;
import com.opencode.utils.JsonUtils;
import org.junit.Test;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/6/6 14:30
 * @Version 1.0
 **/
public class JsonUtilsTest {

    @Test
    public void serializeTest() {
        Person person = new Person();
        person.setId(1L);
        person.setName("小明");
        person.setAge(27);
        String value = JsonUtils.serialize(person);
        System.out.println(value);
    }

    @Test
    public void deserializeTest() {
        String value = "{\"id\":1,\"name\":\"小明\",\"age\":27}";
        Person person = JsonUtils.deserialize(value, Person.class);
        System.out.println(person.getAge());
    }

}
