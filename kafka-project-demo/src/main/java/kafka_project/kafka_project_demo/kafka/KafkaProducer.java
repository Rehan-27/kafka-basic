package kafka_project.kafka_project_demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value("${spring.kafka.topic}")
    private String topicName;

    //Logger instance for logging
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);

    //using spring default template
    private KafkaTemplate<String,String> kafkaTemplate;

    //constructor
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message Sent %s",message));
        kafkaTemplate.send(topicName,message);
    }
}
