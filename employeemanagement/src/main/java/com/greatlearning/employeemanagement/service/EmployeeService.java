package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public void saveOrUpdate(Employee emp);
	public void deleteEmployeeById(int Id);
	public Employee getEmployeeById(int Id);
}
