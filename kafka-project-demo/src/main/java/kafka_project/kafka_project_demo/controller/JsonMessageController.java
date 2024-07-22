package kafka_project.kafka_project_demo.controller;


import kafka_project.kafka_project_demo.kafka.JsonKafkaProducer;
import kafka_project.kafka_project_demo.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publishJson")
    public ResponseEntity<String> publishJsonMsg(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message sent successfully");
    }
}
