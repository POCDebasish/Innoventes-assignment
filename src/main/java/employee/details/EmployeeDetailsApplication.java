package employee.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EmployeeDetailsApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EmployeeDetailsApplication.class, args);

	}

}
