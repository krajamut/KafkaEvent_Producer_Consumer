package com.kiruthika.swipe.producer.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


import com.kiruthika.pojoavro.v2.SwipeEvents;

//import com.kiruthika.swipe.producer.model.Swipe;

@Order(2)
@Component("AvroKafkaPublisher")
@Slf4j
public class KafkaPublisher {

    @Qualifier("AvroKafkaTemplate")
    @Autowired
    KafkaTemplate<String, SwipeEvents> kafkaTemplate;


    public void sendMessageWithCallback(String topicName, String key, SwipeEvents swipe) {
        ListenableFuture<SendResult<String, SwipeEvents>> future =
                kafkaTemplate.send(topicName,key, swipe);

        future.addCallback(new ListenableFutureCallback<SendResult<String, SwipeEvents>>() {
            @Override
            public void onSuccess(SendResult<String, SwipeEvents> result) {
                System.out.println("Message [{}] delivered to Topic [{}], Partition number [{}] sitting on offset [{}]"+
                        swipe.toString()+
                        result.getRecordMetadata().topic()+
                        result.getRecordMetadata().partition()+
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to deliver message [{}]. {}"+
                        swipe.toString()+
                        ex.getMessage());
            }
        });
    }
}