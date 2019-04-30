package my.mongodb.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import my.mongodb.model.Employee;
import my.mongodb.repository.EmployeeRepository;

@Service
public class MyMongoDbController {
	
	EmployeeRepository employeRepo;
	
	public MyMongoDbController(EmployeeRepository employeRepo)
	{
		this.employeRepo = employeRepo;
	}
	
	public List<Employee> getEmployee()
	{
		System.out.println(employeRepo.findAll());
		return employeRepo.findAll();
	}
	
	public Employee getEmployeeByName()
	{
		System.out.println(employeRepo.findAll());
		return employeRepo.findByName("Santiago");
	}
	
	
	public Employee getEmployeeByNameIgnoreCase()
	{
		System.out.println(employeRepo.findAll());
		return employeRepo.findByNameIgnoreCase("santiago");
	}
	public Employee saveEmp()
	{
		Employee emp = new Employee();
		emp.setAge("88");
		emp.setLocation("Pune");
		emp.setName("Santiago");
		emp.setSalary("4444");
		employeRepo.save(emp);
		
		return emp;
	}
	

}
