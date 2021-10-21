//package service;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import data.EmployeeDao;
//import data.impl.EmployeeDaoImpl;
//import model.Employee;
//
//@Service
//public class EmployeeService {
//	
//	@Autowired
//	@Qualifier("hibernateDao")
//	EmployeeDao employeeDao;
//	@PostConstruct
//	public void setup(){
//		
//	}
//	
//	public boolean addEmployeeDetails(Employee employee){
//		
//		System.out.println("Adding Employee");
//		//check if all emp values are present
//		//processing on the data values
//		//data validation
//		//database operation
//	//	EmployeeDao dao=new HibernateEmployeeDaoImpl();
//		EmployeeDao dao=new EmployeeDaoImpl();
//		boolean flag=dao.add(employee);
//		if(employee.getEmpName()!=null || employee.getEmpPhoneNum().equals(""))
//			flag=false;
//		return flag;
//		
//		
//		
//	}
//}


package service;

import org.springframework.stereotype.Service;

import data.EmployeeDao;
import model.Employee;

@Service
public class EmployeeService {
	public boolean addEmployeeDetails(Employee emp){
		System.out.println("Adding employee (in service)");
		//perform bussiness logic here
		EmployeeDao dao=new EmployeeDao();
		boolean flag=false;
		if(emp.getEmpName().equals("")||emp.getEmpPhoneNum().equals("")){
			flag=false;
		}
		
		else
			flag=dao.addEmployee(emp);
		return flag;
	}
	

}
















