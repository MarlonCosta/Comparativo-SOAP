
package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.SayHelloResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(HelloClient quoteClient) {
		return args -> {
			String name = "Naressi";

			if (args.length > 0) {
				name = args[0];
			}
			SayHelloResponse response = quoteClient.SayHello(name).getValue();
			System.err.println(response.getHelloResponse().getMessage());
		};
	}

}
