package funk.shane.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.protobuf.ProtobufMapper;

/**
 * © Fun-School-Workshop
 */
@Configuration
public class WorkshopConfiguration {

	@Primary
	@Bean(name = "jsonBean")
	public ObjectMapper jsonMapper() {
		return Jackson2ObjectMapperBuilder.json().build();
	}

	@Bean(name = "bufBean")
	public ObjectMapper bufMapper() {
		return new ProtobufMapper();
	}
}
