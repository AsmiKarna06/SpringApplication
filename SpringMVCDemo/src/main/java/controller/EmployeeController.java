//package controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import model.Employee;
//import service.EmployeeService;
//
//@Controller
//public class EmployeeController {	
//	@Autowired
//	EmployeeService employeeService;
//	@RequestMapping("/add")
//	
//	
//	/*public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response)
//	{*/
//		
//		/*String empName= request.getParameter("ename");
//		String empPhone= request.getParameter("empPhone");*/
//		
//		
//		/*ModelAndView mv= new ModelAndView();
//		mv.addObject("empname",empName);
//		mv.addObject("phone",empPhone);*/
//	
//	//public String addEmployee(@RequestParam String ename,@RequestParam String empPhone)	{
////		System.out.println("In Create Employee");
//	
//		public String addEmployee(@Valid Employee emp, BindingResult bindingResult){
//	
//		/*Employee emp=new Employee();
//		emp.setEmpName(ename);
//		emp.setEmpPhoneNum(empPhone);*/
//		System.out.println("Employee"+emp);
//	//	EmployeeService service=new EmployeeService();
//		boolean flag;
//		if(bindingResult.hasErrors()){
//			System.out.println("Found errors in form" + bindingResult.getErrorCount());
//			for(Object object:bindingResult.getAllErrors()){
//				if(object instanceof FieldError){
//				FieldError fieldError=(FieldError) object;
//				System.out.println();
//				}
//			}
//			return "error.jsp";
//		}
//		flag=employeeService.addEmployeeDetails(emp);
//		
//		if(flag)
//			return "success";
//		else
//			return "error";
//	}
//
//}


package controller;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.xml.bind.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Employee;
import model.Severity;
import service.EmployeeService;

@Controller
public class EmployeeController {
	
	 

	//3 types how we can perform controller tasks
/*	@Autowired
	EmployeeService service;*/
/*	@RequestMapping("/add")
	public  ModelAndView addEmployee(HttpServletRequest request,HttpServletResponse response){
		
	
		System.out.println("In Create employee");
		boolean flag = false;
		//String empName=request.getParameter("empName");
		//String empPhoneNum=request.getParameter("empPhoneNum");
		ModelAndView mv=new ModelAndView(); 
//		mv.addObject("empName",empName);
//		mv.addObject("empPhoneNum",empPhoneNum);
		Employee emp=new Employee();
//		EmployeeService service=new EmployeeService(); 
//		emp.setEmpName(empName);
//		emp.setEmpPhoneNum(empPhone);
		emp.setEmpName(empName);
		emp.setEmpPhoneNum(empPhoneNum);
		flag=service.addEmployeeDetails(emp);
		if(flag)
			mv.setViewName("success.jsp");//for redirecting
		else
			mv.setViewName("error.jsp");
		return mv;
	}*/
	//method 2
/*	@RequestMapping("/add")
	public String addEmployee(@RequestParam String empName,@RequestParam String empPhoneNum){
		System.out.println("In Create employee");
		boolean flag = false;
		Employee emp=new Employee();
		emp.setEmpName(eName);
		emp.setEmpPhoneNum(ePhone);
		flag=service.addEmployeeDetails(emp);
		if(flag)
			System.out.println("Success");
		else
			System.out.println("Error");
		
		return null;
	}*/
	//method 3
	//valid checks for all conditions
	//bindingResult will store that validation result errors
/*	@Autowired
	EmployeeService service;*/
	
	@Autowired
		EmployeeService service;
	 
	
	 
	 @RequestMapping("/")
	 public ModelAndView home(Model model){
		 System.out.println("in home");
		// model.addAttribute("employee",new Employee());
		ModelAndView mv=new ModelAndView("index");
		//mv.addObject("HeaderStatus","Employee details");
		 return mv;
	 }
	 
	 @ModelAttribute
	 public void commonStuff(Model model)
	 {
		 model.addAttribute("HeaderStatus","Employee details");
		 model.addAttribute("emp",new Employee());
	 }
	 @RequestMapping("/index")
	 public String addemp(){
		 System.out.println("in index");
		 return "add";
	 }
	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute @Valid Employee employee,BindingResult bindingResult){
		System.out.println("Adding employee in controller");
		 boolean flag = false;
		System.out.println("Employee"+employee);
		 if(bindingResult.hasErrors()){
			 System.out.println("Error page though validation...");
			 StringBuffer sb=new StringBuffer();
			 System.out.println("No of errors found" +bindingResult.getErrorCount());
			 for(Object object:bindingResult.getAllErrors())
			 {
				/* if(object instanceof FieldError)
					 
				 {*/
					 FieldError fieldError = (FieldError) object;
					 System.out.println(fieldError.getCode());
					 sb.append(fieldError.getDefaultMessage());
					 sb.append("\n");
				/* } */
			 }
			 
			 System.out.println("errors:"+sb);
			 
			 boolean isSevereError=false;
			 Validator validator=Validation.buildDefaultValidatorFactory().getValidator();
			 Set<ConstraintViolation<Employee>> constraintViolations=validator.validate(employee);
			 if(constraintViolations.size() > 0){
				 for(ConstraintViolation<Employee> violation: constraintViolations) //looping through set
				 {
					 Set<Class<? extends Payload>> payloads=violation.getConstraintDescriptor().getPayload();
					 for(Class<? extends Payload> payload : payloads){
						 if(payload == Severity.Error.class){
							 isSevereError = true;
							 Severity.sendEmail(violation);
						 }
					 }
				 }
			 }
			 if(isSevereError){
				 bindingResult.reject("dob","Mail sent to HR for Year voidation in Date of Birth field");
			 } 
			 
			 bindingResult.reject("errors",sb.toString());
			 return "add";
			 
		 }
		 flag=service.addEmployeeDetails(employee);
		 if(flag)
			 return "success";
		 return "error";
		
	}

	//public void addEmp(@RequestParam String empName,@RequestParam String empPhoneNum ){
	public ModelAndView addEmp(@ModelAttribute("employee") Employee emp){	
		/*Employee emp=new Employee();
		emp.setEmpName(empName);
		emp.setEmpPhoneNum(empPhoneNum);*/
		
		ModelAndView modelandview = new ModelAndView("success");
		return modelandview;
	}
}