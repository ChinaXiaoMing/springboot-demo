package rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nexwise.SpringbootDemoApplication;
import com.nexwise.entity.Users;
import com.nexwise.utils.rabbitmq.Sender;
import com.nexwise.utils.rabbitmq.Sender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class SenderTest {

    @Autowired
    Sender sender;

    @Autowired
    Sender2 sender2;

    @Test
    public void hello() throws JsonProcessingException {
        Users users = new Users();
        users.setId(3);
        users.setUsername("xiaoxiao");
        users.setPassword("123456");
        sender.send();
    }

}
