package edu.cesur.fullstack.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.models.Employee;
import edu.cesur.fullstack.services.EmployeeServices;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
	
	ArrayList<Employee> listEmployees = new ArrayList<>(
			Arrays.asList(new Employee(1, "Daniel", "daniel123@gmail.com", ""),new Employee(2, "Manuel", "manuel24@gmail.com", ""),
					new Employee(3, "Juan", "juanito23@gmail.com", ""),new Employee(4, "Pepe", "pepels@gmail.com", "")));
	
	//Conexión con services
	EmployeeServices employeeServices;
	
	public EmployeeRestController(@Qualifier("generales") EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}
	
	
	//EndPoints
	@GetMapping
	public ResponseEntity<?> getEmployees(){
		ArrayList<Employee> listEmployees = employeeServices.getAllEmployee();
		return ResponseEntity.ok(listEmployees);
	}
	
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		Employee newEmployee = this.employeeServices.saveEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEmployee (@PathVariable Integer id) {
		Employee remoEmployee = this.employeeServices.deleteEmployee(id);
		if (id<0) {
			return ResponseEntity.badRequest().build();
		}
		if (remoEmployee != null) {
            return ResponseEntity.ok(remoEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Integer id){
		Employee getEmployeeId = this.employeeServices.getEmployeeById(id);
		if (id<0) {
			return ResponseEntity.badRequest().build();
		}
		
		if (getEmployeeId != null) {
            return ResponseEntity.ok(getEmployeeId);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		Employee upEmployee = this.employeeServices.updateEmployee(employee);
		if (upEmployee != null) {
            return ResponseEntity.ok(upEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
}
