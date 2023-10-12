package edu.cesur.fullstack.services;

import java.util.ArrayList;

import edu.cesur.fullstack.models.Employee;

public interface EmployeeServices {

	public ArrayList<Employee> getAllEmployee();
	
	public Employee saveEmployee(Employee employee);
	
	public Employee deleteEmployee (Integer id);
	
	public Employee getEmployeeById (Integer id);
	
	public Employee updateEmployee (Employee employee);
}
