package employee.details.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import employee.details.model.Employee;

@Repository
@SuppressWarnings("unchecked")
public interface EmployeeRepository extends MongoRepository<Employee, String>{
	public Employee findByEmployeeid(String empId);
	public Employee save(Employee emp);
	public void deleteByEmployeeid(String empId);
	@Query(value = "{Address.Country:?0}")
	public List<Employee> findbByAddressCountryIgnoreCase(String country);
}
