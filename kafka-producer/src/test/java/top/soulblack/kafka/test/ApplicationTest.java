package top.soulblack.kafka.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.soulblack.producer.service.KafkaProducerService;

/**
 * Created by lxf on 2020/11/5
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    public void send() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            kafkaProducerService.sendMessage("topic01", "hello kafka" + i);
        }

        Thread.sleep(Integer.MAX_VALUE);
    }
}
