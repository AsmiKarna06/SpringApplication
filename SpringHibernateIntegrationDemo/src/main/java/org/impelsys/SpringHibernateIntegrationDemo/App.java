package org.impelsys.SpringHibernateIntegrationDemo;

import java.util.List;

import org.impelsys.config.SpringHibernateXMLConf;
import org.impelsys.data.impl.HibernateEmployeeDaoImpl;
import org.impelsys.model.Department;
import org.impelsys.model.Employee;
import org.impelsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
	@Autowired
	@Qualifier("hibernateDao")
	static HibernateEmployeeDaoImpl hibernateDao;
	@Autowired
	@Qualifier("employeeService")
	static EmployeeService service;
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext applicationcontext = new AnnotationConfigApplicationContext(SpringHibernateXMLConf.class);
    	
    	List<Employee> list;
    	System.out.println("in App.java");
    	hibernateDao=(HibernateEmployeeDaoImpl) applicationcontext.getBean("hibernateDao");
    	
    	Employee emp=new Employee();
    	emp.setEmpName("ASmi");
    	emp.setEmpPhoneNum("123566");
    	Department dept = new Department();
    	dept.setDeptId(12);
    	emp.setDepartment(dept);
    	hibernateDao.getEmployeeList();
    	list=hibernateDao.getEmployeeList();
    	//list=service.getEmployeesCount();
    	for(Employee emp1:list){
    		System.out.println(emp.toString());
    	}
    }
}
