package edu.cesur.fullstack.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import edu.cesur.fullstack.models.Employee;

@Service("generales")
public class EmployeeServiceImpl implements EmployeeServices{

	ArrayList<Employee> listEmployees = new ArrayList<>(
			Arrays.asList(new Employee(1, "Daniel", "daniel123@gmail.com", ""),new Employee(2, "Manuel", "manuel24@gmail.com", ""),
					new Employee(3, "Juan", "juanito23@gmail.com", ""),new Employee(4, "Pepe", "pepels@gmail.com", "")));

	@Override
	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return listEmployees;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.listEmployees.add(employee);
		return employee;
	}

	@Override
	public Employee deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		if (id<0) {          //devuelve nulo si es negativo el id
			return null;
		}
		
		for (Employee e : listEmployees) {
			if(e.getId() == id) {
				this.listEmployees.remove(e);
			}
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		if (id<0) {          //devuelve nulo si es negativo el id
			return null;
		}
		
		for (Employee e : listEmployees) {         
			if(e.getId() == id) {
				return e;
			}
		}
		return null;          //devuelve nulo si no se encuentra el empleado
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		//recorre la lista de empleados uno por uno
		for (Employee e : listEmployees) {
			if(e.getId() == employee.getId()) {          //si el id de alguna iteracion de nuestra lista de empleados coincide con el id del empleado que queramos actualizar, nos meteremos en el if.
				e.setName(employee.getName());
				e.setEmail(employee.getEmail());
				e.setEmployeeCode(employee.getEmployeeCode());
				
				return e;
			}
		}
		return null;  //devuelve nulo si no se ha encontrado a dicho empleado
	}

}
