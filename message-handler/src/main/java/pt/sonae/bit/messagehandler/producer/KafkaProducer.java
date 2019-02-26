package pt.sonae.bit.messagehandler.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.opentracing.Tracer;
import pt.sonae.bit.messagehandler.schema.DocLifeCycle;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Marco Emidio
 */
@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private Tracer tracer;

    @Autowired
    private KafkaTemplate<String, DocLifeCycle> kafkaJsonTemplate;

    @Value("${kafka.topic.json}")
    private String topicJson;
	
	public void sendJsonRequest(DocLifeCycle message) {
		
		log.info("sending message='{}' to topic='{}'", message.getInternalData().getGeneral().getUniqueMsgKey(), topicJson);

		kafkaJsonTemplate.send(topicJson, message);
        
	}

}