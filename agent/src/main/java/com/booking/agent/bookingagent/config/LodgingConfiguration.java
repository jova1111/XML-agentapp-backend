package com.booking.agent.bookingagent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.booking.agent.bookingagent.client.LodgingClient;

@Configuration
public class LodgingConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.booking.agent.bookingagent.model");
		return marshaller;
	}

	@Bean
	public LodgingClient lodgingClient(Jaxb2Marshaller marshaller) {
		LodgingClient client = new LodgingClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
