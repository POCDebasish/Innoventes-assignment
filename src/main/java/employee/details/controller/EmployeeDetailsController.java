package employee.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employee.details.model.Employee;
import employee.details.service.EmployeeDetailsService;
import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeDetailsController {

	@Autowired
	EmployeeDetailsService empService;

	/*
	 * 
	 * This endpoint is to fetch all the Employees present in the database. 
	 * 
	 * */
	@GetMapping("/api/getallemployeedetails")
	public List<Employee> getEmployeeDetails() {
		return empService.getListOfAllEmployees();

	}
	
	/*
	 * 
	 * This endpoint is to fetch Employee details by passing a single or a list of Employee Id
	 * 
	 * */

	@GetMapping("/api/getemployeedetailsbyids/{employeeIds}")
	public List<Employee> getEmployeeDetailsByIds(@PathVariable List<String> employeeIds) {
		return empService.getListOfEmployeesByIds(employeeIds);

	}

	/*
	 * 
	 * This endpoint is used to add Employee in the database. The parameter is
	 * List of Employees so we can save a single or multiple employees through
	 * this endpoint
	 *
	 */
	@PostMapping(value = "/api/addemployeedetails")
	public List<Employee> addEmployeeDetails(@RequestBody List<Employee> employeeList) {
		return empService.saveEmployee(employeeList);

	}

	/*
	 * 
	 * This endpoint is to update an/mnultiple existing Employee(s)' entry
	 * 
	 * */
	@PatchMapping(value = "/api/updateemployeeDetails")
	public List<Employee> updateEmployeeDetails(@RequestBody List<Employee> employeeList) {
		return empService.updateEmployeeDetails(employeeList);

	}
	
	/*
	 * 
	 * This endpoint is to delete an/mnultiple existing Employee(s)' entry
	 * 
	 * */
	@DeleteMapping(value = "/api/deleteemployeeDetails/{employeeIds}")
	public void deleteEmployeeDetails(@PathVariable List<String> employeeIds) {
		empService.deleteEmployeeDetails(employeeIds);

	}
	
	@GetMapping(value = "/api/getStatesByCountry/{country}")
	@ApiOperation(value = "Country name starts with Capital letter and followed by small letter", notes = "Returns list of States for Country")
	public List<String> getStates(@PathVariable String country)
	{
		return empService.getStatesByCountry(country);
				
	}


}
