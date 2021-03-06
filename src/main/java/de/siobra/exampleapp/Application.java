package de.siobra.exampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;

import de.siobra.exampleapp.repositories.PersonRepository;

@ComponentScan
@EnableAutoConfiguration
public class Application implements EmbeddedServletContainerCustomizer{

	@Autowired PersonRepository personRepository;
	@Value("${PORT:}")
	String port;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void customize(ConfigurableEmbeddedServletContainer container) {
        if (port == null || port.isEmpty()) {
            port = "8080";
        }
        int portInt = Integer.valueOf(port);
        container.setPort(portInt);
    }
}