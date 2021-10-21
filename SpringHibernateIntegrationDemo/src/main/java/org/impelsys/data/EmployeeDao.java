package org.impelsys.data;


import java.util.List;

import org.impelsys.model.Employee;

public interface EmployeeDao{
	public int addEmployee(Employee emp);
	
	public default boolean delete(Employee emp)
	{
		return false;
	}
	
	public default Employee getEmployees(int id)
	{
		return null;
	}
	
	public default List<Employee> getAllEmployees()
	{
		return null;
	}
	
	public default List<Integer> getDistinctSalary()
	{
		return null;
	}
	
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeList(int from, int noOfRows);
	Long getEmployeesCount();
	public int updateEmployeeDepartment(Employee emp);

	public void assignEmployeeProjects();
	
	
}


/*@Repository("employeeDao")
public class EmployeeDao {
	public boolean addEmployee(Employee emp){
		System.out.println("Adding employee (in data/dao)");
		boolean flag=true;
		//perform database operations here
		System.out.println(emp.getEmpName()+emp.getEmpPhoneNum());
		
		return flag;
	}
	public default boolean delete(Employee emp){return false;};
	public List<Employee> getEmployees() {
		return null;
	}

}
*/