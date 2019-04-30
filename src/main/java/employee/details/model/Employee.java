package employee.details.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "Employee")
@JsonInclude(Include.NON_NULL)
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	@Indexed(unique = true)
	private String employeeid;
	private String first_name;
	private String dob;
	private String designation;
	private List<Address> address;

	
	public String getEmployee_id() {
		return employeeid;
	}
	public void setEmployee_id(String employee_id) {
		this.employeeid = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
