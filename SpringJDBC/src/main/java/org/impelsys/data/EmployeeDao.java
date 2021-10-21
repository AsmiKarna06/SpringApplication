package org.impelsys.data;

import org.impelsys.model.Employee;

public interface EmployeeDao{
	public int saveEmp(Employee e);
	public Employee getEmployee(int id);

}

