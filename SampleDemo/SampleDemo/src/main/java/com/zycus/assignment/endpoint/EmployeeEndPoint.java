package com.zycus.assignment.endpoint;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zycus.assignment.model.Employee;
import com.zycus.assignment.model.ResponseStructure;
import com.zycus.assignment.service.IEmployeeService;

@RestController(value = "/employeeEndPoint")
public class EmployeeEndPoint {

	@Autowired
	private IEmployeeService empService;

	// -------------------Retrieve All Employees

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseStructure getAllEmployee() {
		return empService.getAllEmployee();
	}

	// -------------------Retrieve Single Employee

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseStructure getEmployeeById(@PathVariable("id") int id) {
		System.out.println("Fetching User with id " + id);
		return empService.getEmployeeById(id);
	}

	// -------------------Create an Employee
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseStructure saveEmployee(@RequestBody Employee user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getEmployeeName());
		return empService.saveEmployee(user);
	}

	// ------------------- Update an Employee
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseStructure updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		System.out.println("Updating User " + id);
		return empService.updateEmployee(employee, id);
	}

	// ------------------- Delete a Employee
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseStructure deleteEmployee(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting User with id " + id);
		return empService.deleteEmployee(id);
	}

}
