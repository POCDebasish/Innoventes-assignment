package my.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import my.mongodb.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

	public Employee findByName(String name);
	public Employee findByNameIgnoreCase(String name);
}
