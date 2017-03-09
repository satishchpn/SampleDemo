package com.zycus.assignment.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zycus.assignment.model.Employee;
import com.zycus.assignment.model.ResponseStructure;
import com.zycus.assignment.service.IEmployeeService;

@Component
@Scope("prototype")
@Path("/employeeRestEndpoint")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeRestEndpoint {

	@Autowired
	IEmployeeService empService;

	private static Logger log = Logger.getLogger(EmployeeRestEndpoint.class);

	@POST
	public ResponseStructure saveEmployee(Employee emp) {
		log.info("saveEmployee() called...");
		return empService.saveEmployee(emp);
	}

	@GET
	@Path("{studentId}")
	public ResponseStructure getEmployeeById(@PathParam("studentId") long id) {
		log.info("----------getEmployeeById() Called----------");
		return empService.getEmployeeById(id);
	}

	@GET
	public ResponseStructure getAllEmployee() {
		log.info("----------getAllEmployee() Called----------");
		return empService.getAllEmployee();
	}

	@PUT
	@Path("{studentId}")
	public ResponseStructure updateStudent(Employee emp, @PathParam("studentId") long id) {
		log.info("updateStudent called..." + emp + "\tid: " + id);
		return empService.updateEmployee(emp, id);
	}

	@DELETE
	@Path("{studentId}")
	public ResponseStructure deleteStudent(@PathParam("studentId") long id) {
		log.info("deleteStudent called..." + id);
		return empService.deleteEmployee(id);
	}

}
