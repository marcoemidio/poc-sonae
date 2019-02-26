package pt.sonae.bit.messagehandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;

@SpringBootApplication
public class MessageHandlerApplication {

	@Value("${jaeger.service.name}")
	private String jaegerServiceName;
	
	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration(jaegerServiceName).getTracer();
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageHandlerApplication.class, args);
	}

}
