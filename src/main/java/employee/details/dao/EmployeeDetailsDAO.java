package employee.details.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import employee.details.model.Employee;
import employee.details.repository.EmployeeRepository;

@Component
public class EmployeeDetailsDAO {

	@Autowired
	EmployeeRepository empRepo;

	public List<Employee> saveEmployees(List<Employee> empList) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (Employee emp : empList) {
			employeeList.add(empRepo.save(emp));
		}
		return employeeList;
	}

	public List<Employee> getDetailsOfAllEmployee() {
		return empRepo.findAll();
	}

	public List<Employee> getEmployeeDetailsByIds(List<String> empIds) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (String empId : empIds) {
			employeeList.add(empRepo.findByEmployeeid(empId));
		}
		return employeeList;
	}

	public List<Employee> updateEmployee(List<Employee> empList) {

		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee();
		for (Employee emp : empList) {

			employee = empRepo.findByEmployeeid(emp.getEmployee_id());
			employee.setAddress(emp.getAddress());
			employee.setDesignation(emp.getDesignation());
			employee.setDob(emp.getDob());
			employee.setFirst_name(emp.getFirst_name());
			employee.setEmployee_id(emp.getEmployee_id());
			employeeList.add(empRepo.save(employee));
		}
		return employeeList;
	}

	public void deleteEmployeeDetailsByIds(List<String> empIds) {

		for (String empId : empIds) {
			empRepo.deleteByEmployeeid(empId);
		}
	}

	public List<String> getListOfStatesByCountry(String country) {

		List<String> statesList = new ArrayList<String>();

		List<Employee> empList = empRepo.findbByAddressCountryIgnoreCase(country);
		for (Employee emp : empList) {
			for (int i = 0; i < emp.getAddress().size(); i++) {
				if (emp.getAddress().get(i).getCountry().equals(country)) {
					if (!statesList.contains(emp.getAddress().get(i).getState()))
						statesList.add(emp.getAddress().get(i).getState());
				}
			}
		}
		return statesList;

	}
}
