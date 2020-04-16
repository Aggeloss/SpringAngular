package com.apiproject.tect;

import com.apiproject.tect.entities.Product;
import com.apiproject.tect.services.ProductService;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TectApplication {

	@Autowired
	private ProductService productService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebServerFactoryCustomizer customizer() {
		return container -> {
			if (container instanceof TomcatServletWebServerFactory) {
				TomcatServletWebServerFactory tomcat = (TomcatServletWebServerFactory) container;
				tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TectApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Demo2();
//	}

	private void Demo1() {
		for (Product product : productService.findAll()) {
			System.out.println("id: " + product.getId());
			System.out.println("name: " + product.getName());
			System.out.println("price: " + product.getPrice());
			System.out.println("quantity: " + product.getQuantity());
			System.out.println("status: " + product.isStatus());
			System.out.println("==============================\n");
		}
	}

	private void Demo2() {
		for (Product product : productService.search(5, 10)) {
			System.out.println("id: " + product.getId());
			System.out.println("name: " + product.getName());
			System.out.println("price: " + product.getPrice());
			System.out.println("quantity: " + product.getQuantity());
			System.out.println("status: " + product.isStatus());
			System.out.println("==============================\n");
		}
	}
}
