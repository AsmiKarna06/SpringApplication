package org.impelsys.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.impelsys.data.EmployeeDao;
import org.impelsys.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Service
@Component("employeeService")
public class EmployeeService {
	@Autowired
	@Qualifier("hibernateDao")
	EmployeeDao employeeDao;
	@PostConstruct
	public void setup(){
	
	}
	public int updateEmployeedept(Employee emp){
		return employeeDao.updateEmployeeDepartment(emp);
	}
	public Employee displayEmployees(int empId){
		return employeeDao.getEmployees(empId);
	}
	
	public List<Integer> displayDistinctSalary(){
		return employeeDao.getDistinctSalary();
	}
	
	public int addEmployeeDetails(Employee emp)
	{
		int empId;
		System.out.println("Adding employee (in service)");
		empId = employeeDao.addEmployee(emp);
		return empId;
	}
	
	public Long getEmployeesCount()
	{
		return employeeDao.getEmployeesCount();
	}
	public List<Employee> displayAllEmployees(){
		return employeeDao.getEmployeeList();
	}
	public List<Employee> displayAllEmployees(int rowFrom, int noOfRecords){
		return employeeDao.getEmployeeList(rowFrom,noOfRecords);
	}
	public void assignEmployeeProjects() {
		// TODO Auto-generated method stub
		employeeDao.assignEmployeeProjects();
		
	}
	
}

/*HibernateEmployeeDaoImpl dao;
public int addEmployeeDetails(Employee emp){
	System.out.println("Adding employee (in service)");
	//perform business logic here
	boolean flag=false;
		flag=dao.addEmployee(emp);
	return 0;*/