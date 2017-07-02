package com.slend.entity.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		packages("com.slend.rest.api.borrower");
	}
}
