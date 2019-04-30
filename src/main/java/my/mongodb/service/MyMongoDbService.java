package my.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import my.mongodb.controller.MyMongoDbController;
import my.mongodb.model.Employee;

@RestController
public class MyMongoDbService {
	
	@Autowired
	MyMongoDbController myMongoDbController;
	
	@GetMapping(value ="/fetchdetails")
	public List<Employee> getEmpoyeeDetails()
	{
		return myMongoDbController.getEmployee();
		
	}
	
	@GetMapping(value ="/fetchdetailsByName")
	public Employee getEmpoyeeDetailsByName()
	{
		return myMongoDbController.getEmployeeByName();
		
	}
	
	@GetMapping(value ="/saveEmployee")
	public Employee saveEmployee()
	{
		return myMongoDbController.saveEmp();	
	}
	
	@GetMapping(value ="/fetchdetailsByNameIgnore")
	public Employee getEmpoyeeDetailsByNameIgnoreCase()
	{
		return myMongoDbController.getEmployeeByNameIgnoreCase();
		
	}

}
