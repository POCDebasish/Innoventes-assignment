package employee.details.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import employee.details.model.Employee;

@Component
public class EmployeeValidator {

	public void validateEmployee(List<Employee> empList) {

		if (empList.equals(null) || empList.isEmpty()) {
			throw new RuntimeException("Employee cannot be null or empty");
		}
		for (Employee emp : empList) {
			try {

				if ((emp.getFirst_name() == null || emp.getFirst_name().isEmpty())
						|| (emp.getEmployee_id() == null || emp.getEmployee_id().isEmpty())
						|| (emp.getDesignation() == null || emp.getDesignation().isEmpty())) {
					throw new Exception();
				}
			} catch (Exception e) {
				throw new RuntimeException(
						"First name, EmployeeId or Designation is null. These feilds are mandatory and cannot be null");
			}
		}
	}
}
