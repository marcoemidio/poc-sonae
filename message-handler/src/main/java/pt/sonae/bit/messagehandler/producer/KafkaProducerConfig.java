package pt.sonae.bit.messagehandler.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import io.opentracing.Tracer;
import io.opentracing.contrib.kafka.spring.TracingProducerFactory;
import lombok.extern.slf4j.Slf4j;

import pt.sonae.bit.messagehandler.schema.DocLifeCycle;

/**
 * @author Marco Emidio
 */
@Configuration
@Slf4j
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
	
	@Autowired
	private Tracer tracer;
	
	@Bean
    public Map<String, Object> kafkaJsonProducerConfigs() {
		
		log.debug("Loading kafka Json producer configs...");
		
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.RETRIES_CONFIG, 3);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        
        return props;
    }
	
	// Decorate ProducerFactory with TracingProducerFactory
	@Bean
    public ProducerFactory<String, DocLifeCycle> kafkaJsonProducerFactory() {
    	
    	log.debug("Loading kafka Json producer factory...");
    	
    	return new TracingProducerFactory<>(new DefaultKafkaProducerFactory<>(kafkaJsonProducerConfigs()), tracer);
    }
	
	// Use decorated JsonProducerFactory in KafkaTemplate
	@Bean
    public KafkaTemplate<String, DocLifeCycle> kafkaJsonTemplate() {
    	
    	log.debug("Loading kafka Json template...");
    	
    	return new KafkaTemplate<>(kafkaJsonProducerFactory());

    }



}