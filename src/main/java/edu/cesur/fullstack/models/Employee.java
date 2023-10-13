package edu.cesur.fullstack.models;

import edu.cesur.fullstack.validators.ValidEmployeeCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Employee {
	
	@Positive
	private Integer id;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@Email
	private String email;
	
	@ValidEmployeeCode
	private String employeeCode;

	public Employee(Integer id, String name, String email, String employeeCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeCode = employeeCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", employeeCode=" + employeeCode + "]";
	}
	
	
	
}
