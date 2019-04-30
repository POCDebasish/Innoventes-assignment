package employee.details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.details.dao.EmployeeDetailsDAO;
import employee.details.model.Employee;
import employee.details.validator.AddressValidator;
import employee.details.validator.EmployeeValidator;

@Service
public class EmployeeDetailsService {
	
	@Autowired
	EmployeeDetailsDAO empDAO;
	@Autowired
	EmployeeValidator empValidator;
	@Autowired
	AddressValidator addressValidator;
	
	public List<Employee> saveEmployee(List<Employee> empList)
	{
		empValidator.validateEmployee(empList);
		addressValidator.validateEmployeeAddress(empList);
		return empDAO.saveEmployees(empList);
	}
	
	public List<Employee> getListOfAllEmployees()
	{
		return empDAO.getDetailsOfAllEmployee();
	}
	
	public List<Employee> getListOfEmployeesByIds(List<String> empIds)
	{
		return empDAO.getEmployeeDetailsByIds(empIds);
	}

	public List<Employee> updateEmployeeDetails(List<Employee> empList) {
		
		empValidator.validateEmployee(empList);
		addressValidator.validateEmployeeAddress(empList);
		
		return empDAO.updateEmployee(empList);
	}

	public void deleteEmployeeDetails(List<String> employeeIds) {
		empDAO.deleteEmployeeDetailsByIds(employeeIds);
	}

	public List<String> getStatesByCountry(String country) {
		
		return empDAO.getListOfStatesByCountry(country);
	}
	
}
