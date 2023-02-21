package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	/*
	 * /employees  GET
	 * /employees/new
	 * /employees/edit{id}
	 * /employees/delete{id}
	 *  /employees  POST
	 */
	
	@RequestMapping("/employees")
	public String getAllEmployees(Model model) {
		List<Employee> result = service.getAllEmployees();
		model.addAttribute("employees", result);
		return "employees";
	}
	
	@RequestMapping("/employees/new")
	public String addNewEmployee(Model model) {
		Employee result = new Employee();
		model.addAttribute("employee", result);
		return "create_employee";
	}
	
	@RequestMapping("/employees/edit/{id}")
	public String UpdateEmployee(Model model, @PathVariable("id") int id) {
		Employee result = service.getEmployeeById(id);
		model.addAttribute("employee", result);
		return "edit_employee";
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable("id") int id) {
		service.deleteEmployeeById(id);
		return "redirect:/employees";
	}

	@PostMapping("/employees")
	public String saveNewEmployee(@ModelAttribute("employees") Employee emp) {
		service.saveOrUpdate(emp);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@ModelAttribute("employee") Employee emp,@PathVariable("id") int id) {
		Employee existingEmployee = service.getEmployeeById(id);
		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setEmail(emp.getEmail());
		service.saveOrUpdate(existingEmployee);
		return "redirect:/employees";
	}
}
