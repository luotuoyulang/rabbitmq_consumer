package cn.luotuoyulang.rabbitmq_consumer.consumer;

import cn.luotuoyulang.rabbitmq_consumer.entity.Dog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${imps.record.order.queue.name}",containerFactory = "singleListenerContainer")
    public void consumeOrder(@Payload byte[] message) {
        log.info("===开始消费==========rabbitmq来自===============message[{}]=========开始消费==== ,", "imps.record.order.queue.name");
        try {
            Dog dog = objectMapper.readValue(message, Dog.class);
            System.err.println("====================="+dog);
//            recodeLogService.save(impsRecodeLog);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("=============rabbitmq来自===============message[{}]=========出错==== ,"+ e.getMessage(), "imps.record.order.queue.name");
        }
    }
}
