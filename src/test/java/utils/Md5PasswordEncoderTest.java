package utils;

import com.opencode.utils.EncryptUtils;
import com.opencode.utils.Md5PasswordEncoder;
import org.junit.Test;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/4/4 15:17
 * @Version 1.0
 **/
public class Md5PasswordEncoderTest {

    @Test
    public void encodeTest() {
        String password = "123456";
        System.out.println(EncryptUtils.md5Encrypt("123456"));
    }

}
