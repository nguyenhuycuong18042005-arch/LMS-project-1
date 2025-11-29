package cuong.nh5285.hust.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "cuong.nh5285.hust.lms")
@SpringBootApplication
public class LMSApplication {

	public static void main(String[] args) {

		SpringApplication.run(LMSApplication.class, args);
		System.out.println("http://localhost:8080/login");
		System.out.println("http://localhost:8080/books");
	}

}
