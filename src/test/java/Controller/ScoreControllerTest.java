package Controller;

import com.nexwise.SpringbootDemoApplication;
import com.nexwise.dao.ScoreMapper;
import com.nexwise.entity.Score;
import com.nexwise.service.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class ScoreControllerTest {

    @Autowired
    ScoreService scoreService;

    @Test
    public void addScore() {
        Score score = new Score();
        score.setId(1);
        score.setScore(new BigDecimal(1.33f));
        scoreService.addScore(score);
    }

    @Test
    public void getScore() {
        Score score = scoreService.getScore(1);
        System.out.println(score.getId());
        System.out.println(score.getScore());
    }

}
