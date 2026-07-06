package com.emp.main.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.main.entity.Employee;
import com.emp.main.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	  private EmployeeRepository employeeRepository;
	
	@PostMapping("/addemp")
	public Employee addemp(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
		return employee;
	}
	
	@GetMapping("/getemp")
	public List<Employee> getemp(){
		return employeeRepository.findAll();
	}
	
	@PutMapping("/updateemp/{id}")
	public Employee updateemp(@RequestBody Employee employee,@PathVariable int id) throws Exception {
		Optional<Employee> findById = employeeRepository.findById(id);
		
		Employee save;
		if(findById.isPresent()) {
			employeeRepository.delete(findById.get());
			 save = employeeRepository.save(employee);
		}
		else {
			throw new Exception("employee doesnot exist with id:"+ id);
		}
		return save;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@RequestBody Employee employee,@PathVariable int id) throws Exception {
		Optional<Employee> findById = employeeRepository.findById(id);
		
		if(findById.isPresent()) {
			employeeRepository.delete(findById.get());
			return "employee data deleted.........";
		}
		else {
			throw new Exception("employee doesn't exist with id:"+ id);
		}
	}
}
