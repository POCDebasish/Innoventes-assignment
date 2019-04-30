package employee.details.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import employee.details.model.Employee;

@Component
public class AddressValidator {

	public void validateEmployeeAddress(List<Employee> empList) {

		if (empList.equals(null) || empList.isEmpty()) {
			throw new RuntimeException("Employee cannot be null or empty");
		}
		for (Employee emp : empList) {
			try {
				for (int i = 0; i < emp.getAddress().size(); i++) {

					if ((emp.getAddress().get(i).getAddressLine1() == null
							|| emp.getAddress().get(i).getAddressLine1().isEmpty())
							|| (emp.getAddress().get(i).getCity() == null
									|| emp.getAddress().get(i).getCity().isEmpty())) {
						throw new Exception();
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(
						"Either or both of Employee Address' city or AddressLine1 is null. These feilds are mandatory and cannot be null");
			}
		}
	}

}
