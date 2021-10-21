//package data;
//
//import org.springframework.stereotype.Repository;
//
//import model.Employee;
//
//@Repository
//public interface EmployeeDao {
//	
//	public boolean add(Employee employee);
//	
//}
package data;

import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
public class EmployeeDao {
	public boolean addEmployee(Employee emp){
		System.out.println("Adding employee (in data/dao)");
		boolean flag=true;
		//perform database operations here
		System.out.println(emp.getEmpName()+emp.getEmpPhoneNum());
		return flag;
	}

}
