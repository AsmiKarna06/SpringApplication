package org.impelsys.controller;

import java.util.List;

import org.impelsys.model.BankAccount;
import org.impelsys.model.Department;
import org.impelsys.model.Employee;
import org.impelsys.model.Employee.EmployeeFactory;
import org.impelsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	
	@RequestMapping("/updateDept/{empId}/{deptId}")
	public void updateDept(@PathVariable int empId, @PathVariable int deptId , Model model ){
		Employee emp=new Employee();
		emp.setEmpId(empId);
		Department d=new Department();
		d.setDeptId(deptId);
		emp.setDepartment(d);
		service.updateEmployeedept(emp);
		
	}
	
	
	
	
	/* localhost:8080/HibernateDemo/employee/update/asmi/124432/mangalore -> RESTful url
	 * localhost:8080/HibernateDemo/employee/update?ename==asmi&phone=25525&city=mangalore  
	 * 
	 */
	@RequestMapping("/update/{ename}/{phone}/{city}")
	public String update(@PathVariable String ename, @PathVariable String phone , @PathVariable String city, Model model )
	{
		Employee e= new Employee();
		e.setEmpName(ename);
		e.setEmpPhoneNum(phone);
		//update operation
		int count = service.updateEmployeedept(e);
		if(count>=1){
			model.addAttribute("emp",e);
			return "show";
		}
		else
		{
			return "error";
		}
		
	}
	
	@RequestMapping("/create/{count}")
//	localhost:8080/HibernateDemo/employee/create/100	 
	public void createEmpInBulk(@PathVariable int count){
		Employee e=new Employee(); 
		for(int i=0;i<count;i++){
			e.setEmpName("emp:"+i);
			e.setEmpPhoneNum("124343453"+i);
			//populate all the fields 
			service.addEmployeeDetails(e);
		}
		System.out.println("Processing Complete");
	}
	
	@RequestMapping("/getPage/{pageNum}")
	public String page(@PathVariable String pageNum,Model model){
		//fetching employees from the table with the start row count based on page number
		int pageNo = Integer.parseInt(pageNum);	//let pageNo=2
		int numOfRecords=10;	
		int rowFrom=1;
		rowFrom=((pageNo-1)* numOfRecords)+1; // ((2-1)*10)+1=1
		List<Employee> listEmp = service.displayAllEmployees(rowFrom, numOfRecords);
		model.addAttribute("empList",listEmp);
		return "home";
	}
	
	@RequestMapping("/")
	public String home(Model model)
	{
		System.out.println("In /employee/");
		Employee emp=new Employee();
		emp.setEmpName("Atul");
		Department dept= new Department();
		dept.setDeptName("Admin2");
		emp.setDepartment(dept);
		
		
		//System.out.println("dept added");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountType("Savings Account");
		bankAccount.setBankName("AXIS Bank");
		bankAccount.setIfsc("AXIS004240");
		System.out.println("Bank details added");
		
		emp.setBankAccount(bankAccount);
		service.addEmployeeDetails(emp);
		service.assignEmployeeProjects();
		
		Long empCount = service.getEmployeesCount();
		model.addAttribute("employee",emp);
		model.addAttribute("empCount",empCount);
		model.addAttribute("firstCall",true);
		
		return "home";
	}

//	@RequestMapping("/")
//	public String home(Model model){
//		
//		Employee emp=new Employee();
//		emp.setEmpName("Asm");
//		Department dept = new Department();
//		dept.setDeptName("Admin");
////		dept.setDeptId(5);
//		emp.setDepartment(dept);
////		service.addEmployeeDetails(emp);
//		System.out.println("Dept added");
//		
//		BankAccount bankAccount =new BankAccount();
//		bankAccount.setAccountType("Saving Account");
//		bankAccount.setBankName("Axis bank");
//		bankAccount.setIfsc("AXIS000876");
//		System.out.println("bank details added");
//		emp.setBankAccount(bankAccount);
//		service.addEmployeeDetails(emp);   //for a given employee it will also imported the bankaccount
//		service.assignEmployeeProjects();
//		
//		Long empCount = service.getEmployeesCount();
//		model.addAttribute("employee",emp);
//		model.addAttribute("empCount",empCount);
//		model.addAttribute("firstCall",true);
//		System.out.println("In employecontroller");
//		 return "home";
////		System.out.println("In home");
////		
////		Employee emp = new Employee();
////		emp.setEmpName("John");
////		emp.setEmpPhoneNum("246810");
////		emp.setExperience("4");
////		emp.setGender("M");
////		emp.setSalary(23000);
////		//emp.setAge(10);
////		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
////		try
////		{
////			Date dob =sdf.parse("01/01/2000");
////			emp.setDob(dob);
////		}
////		catch(ParseException e1)
////		{
////			e1.printStackTrace();
////		}
////		
////		
////				
////		int empId = service.addEmployeeDetails(emp);
//		
//		/* List<Employee> list = service.displayAllEmployees();
//		 for(Employee e: list)
//			 System.out.println(e);
//		 List<Integer> list1 = service.displayDistinctSalary();
//		 for(Integer e1: list1)
//			 System.out.println(e1);
//		 model.addAttribute("empList1",list1);	 
//			 */
//		 
////		 model.addAttribute("empList",list); 
//		
//		 
//	//	service.addEmployeeDetails(emp);
//	
////		 model.addAttribute("empList1",list1);
////		//model.addAttribute("employee",EmployeeFactory.create());
////		return "home";
//	}
	
	@ModelAttribute
	public void commStuff(Model model){
		model.addAttribute("HeaderStatus", "Welcome to Impelsys!!");
		model.addAttribute("emp", new Employee());
	}
	@RequestMapping("/index")
	public String addemp(){
		return "add";
	}
	@RequestMapping("/tryAgain")
	public String tryAgain(){
		return "add";
	}
	@RequestMapping("showLogin")
	public String showLogin(){
		return "login";
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Enter Employee details");
		model.addAttribute("emp",EmployeeFactory.create());
	}

	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("emp") Employee emp){
		System.out.println("Addin g employee (in controller)");
		 int flag = 1;
		
		 flag=service.addEmployeeDetails(emp);
		 if(true)
			 return "success";
		 return "error";
		
	}
	
}
