package top.soulblack.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

/**
 * Created by lxf on 2020/11/5
 */
@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(groupId = "group01", topics = "topic01")
    public void onMessage(ConsumerRecord<String, Object> record, Acknowledgment acknowledgment, Consumer<?, ?> consumer) {
        log.info("消息端接收消息：{}", record.value());
        // 手动签收 给配置一致
        acknowledgment.acknowledge();
        System.out.println(record.value());
    }
}
