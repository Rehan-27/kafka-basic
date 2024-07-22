package kafka_project.kafka_project_demo.kafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Value("${spring.kafka.topic}")
    private String topicName;

    @Value("${spring.kafka.topic-json}")
    private String topicJsonName;

    @Bean
    public NewTopic rehanTopics(){
        return TopicBuilder.name(topicName).build();
    }

    @Bean
    public NewTopic rehanTopicsJson(){
        return TopicBuilder.name(topicJsonName).build();
    }
}
